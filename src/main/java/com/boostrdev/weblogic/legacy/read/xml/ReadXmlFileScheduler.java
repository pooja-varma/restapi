package com.boostrdev.weblogic.legacy.read.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.boostrdev.weblogic.legacy.dao.entity.PaymentAksDetail;
import com.boostrdev.weblogic.legacy.dao.entity.PaymentBatchAksDetail;
import com.boostrdev.weblogic.legacy.pain002.Document;
/*import com.citiconnect.payment.dao.entity.PaymentAksDetail;
import com.citiconnect.payment.dao.entity.PaymentBatchAksDetail;
import com.citiconnect.payment.dao.repository.PaymentAksDetailRepository;
import com.citiconnect.payment.dao.repository.PaymentBatchAksDetailRepository;*/

/**
 * @author dolai_p
 *
 */
@Configuration
@EnableScheduling
@Component
public class ReadXmlFileScheduler {
	private final Logger logger = LoggerFactory.getLogger(ReadXmlFileScheduler.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${file.path.pain.xml.out.dir}")
	private String PAIN_OUT_FILE_PATH;

	@Value("${file.path.pain.xml.archive.dir}")
	private String PAIN_ARCHIVE_FILE_PATH;

	/*
	 * @Autowired private PaymentAksDetailRepository paymentAksDetailRepository;
	 * 
	 * @Autowired private PaymentBatchAksDetailRepository
	 * paymentBatchAksDetailRepository;
	 */
	private static List<String> painFiles = new ArrayList<String>();

	@Scheduled(fixedRateString = "${parse.scheduler.job}")
	public void readPain002Xmlfiles() throws IOException {
		logger.info("logger ============= schedules starting ===========");
		File folder = new File(PAIN_OUT_FILE_PATH);
		File[] fileNames = folder.listFiles();
		JAXBContext jaxbContext;
		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbContext = JAXBContext.newInstance(com.boostrdev.weblogic.legacy.pain002.Document.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException ex) {
			logger.error(" JAXBException on file read " + ex.getMessage());
		} catch (Exception ex) {
			logger.error(" Exception on file read " + ex.getMessage());
		}

		for (File file : fileNames) {
			try {
				System.out.println(" Run time Exection on readPain002AksFile():: ");
				String files = file.getAbsoluteFile().toString();
				String fileName = file.getName();
				this.logger.info("********fileName ============= schedules starting ===========" + fileName);
				if (file.isDirectory()) {
				} else if (files.endsWith(".xml")) {
					String xml = new String(Files.readAllBytes(Paths.get(files)));
					StringReader reader = new StringReader(xml);
					Document document = (com.boostrdev.weblogic.legacy.pain002.Document) jaxbUnmarshaller
							.unmarshal(reader);
					if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getGrpSts() != null) {
						readPain002BatchAksFile(document, fileName);
					} else {
						readPain002AksFile(document, fileName);
					}
					fileMove(files, fileName);
				}
			} catch (JAXBException ex) {
				logger.error(" JAXBException on file read " + ex.getMessage());
				continue;
			} catch (Exception ex) {
				logger.error(" Exception on file read " + ex.getMessage());
				continue;
			} catch (Throwable ex) {
				logger.error(" Run time Exection on readPain002AksFile():: " + ex.getMessage());
				System.out.println(" Run time Exection on readPain002AksFile():: " + ex.getMessage());
				continue;
			}
		}
		logger.info("logger ============= schedules end ===========");
	}

	private void fileMove(String file, String fileName) throws Exception {
		Path movingFile = Files.move(Paths.get(file), Paths.get(PAIN_ARCHIVE_FILE_PATH + fileName));
		if (movingFile != null) {
			logger.debug("File renamed and moved successfully");
		} else {
			logger.info("Failed to move the file");
		}
	}

	private void readPain002AksFile(Document document, String fileName) throws Exception {
		logger.debug("logger start============= readPain002AksFile starting ===========");
		System.out.println("logger start============= readPain002AksFile starting ===========");
		PaymentAksDetail paymentAksDetail = new PaymentAksDetail();
		paymentAksDetail.setCreated_by(new Integer(1000));
		Date date = new Date();
		paymentAksDetail.setCreated_date(date);
		if (document.getCstmrPmtStsRpt().getGrpHdr().getMsgId() != null) {
			paymentAksDetail.setAck_id(document.getCstmrPmtStsRpt().getGrpHdr().getMsgId());
		}
		if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getOrgnlMsgId() != null) {
			paymentAksDetail.setPayment_instruction_id(
					new BigDecimal(document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getOrgnlMsgId()));
		}

		if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getNbOfTxsPerSts().get(0).getDtldSts()
				.value() != null) {
			paymentAksDetail.setAck_status(
					document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getNbOfTxsPerSts().get(0).getDtldSts().value());
		}
		if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getOrgnlMsgNmId() != null) {
			paymentAksDetail.setFile_name(fileName);

		}
		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0).getOrgnlTxRef().getAmt()
				.getInstdAmt().getValue() != null) {
			paymentAksDetail.setPayment_amount(document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0)
					.getTxInfAndSts().get(0).getOrgnlTxRef().getAmt().getInstdAmt().getValue().toString());
		}
		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0).getOrgnlTxRef().getAmt()
				.getInstdAmt().getCcy() != null) {
			paymentAksDetail.setPayment_currenc_code(document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0)
					.getTxInfAndSts().get(0).getOrgnlTxRef().getAmt().getInstdAmt().getCcy());
		}
		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0).getOrgnlTxRef()
				.getReqdExctnDt() != null) {
			Date paymentDate = new SimpleDateFormat("yyyy-MM-dd").parse(document.getCstmrPmtStsRpt()
					.getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0).getOrgnlTxRef().getReqdExctnDt().toString());
			paymentAksDetail.setPayment_date(paymentDate);
		}
		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0).getTxSts() != null) {
			paymentAksDetail.setPayment_status(document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0)
					.getTxInfAndSts().get(0).getTxSts().name());
		}

		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0).getStsRsnInf().get(0)
				.getAddtlInf() != null) {
			StringBuilder sb = new StringBuilder();
			for (String addInfo : document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0)
					.getStsRsnInf().get(0).getAddtlInf()) {
				sb.append(addInfo).append('\n');
			}
			paymentAksDetail.setAdd_Info(sb.toString());
		}

		paymentAksDetail.setUpdated_date(date);
		if (paymentAksDetail.getCreated_by() == null)
			paymentAksDetail.setCreated_by(1000);
		if (paymentAksDetail.getUpdated_by() == null)
			paymentAksDetail.setUpdated_by(1000);

		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getTxInfAndSts().get(0)
				.getOrgnlEndToEndId() != null) {
			paymentAksDetail.setPaymentNumber(new BigDecimal(document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0)
					.getTxInfAndSts().get(0).getOrgnlEndToEndId()));
		}

		if (document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getOrgnlPmtInfId() != null) {
			paymentAksDetail
					.setLogicalGrpRef(document.getCstmrPmtStsRpt().getOrgnlPmtInfAndSts().get(0).getOrgnlPmtInfId());
		}

		String insertpaymentAksDetail = insertPaymentAksDetailQuery();
		// paymentAksDetailRepository.save(paymentAksDetail);

		int row = saveRecord(insertpaymentAksDetail, paymentAksDetail);
		System.out.print("Insert payment Ack details" + row);
		painFiles.add(fileName);
		logger.debug("Files successfully procced::" + painFiles);

	}

	private Integer saveRecord(String insertpaymentAksDetailQuery, PaymentAksDetail paymentAksDetail) {
		// define query arguments
		Object[] params = new Object[] { paymentAksDetail.getAck_id(), paymentAksDetail.getPayment_instruction_id(),
				paymentAksDetail.getPayment_id(), paymentAksDetail.getAck_status(), paymentAksDetail.getFile_name(),
				paymentAksDetail.getOrg_id(), paymentAksDetail.getFile_status(), paymentAksDetail.getPayment_amount(),
				paymentAksDetail.getPayment_currenc_code(), paymentAksDetail.getPayment_date(),
				paymentAksDetail.getPayment_status(), paymentAksDetail.getAdd_Info(), paymentAksDetail.getCreated_by(),
				paymentAksDetail.getCreated_date(), paymentAksDetail.getUpdated_by(),
				paymentAksDetail.getUpdated_date(), paymentAksDetail.getPaymentNumber(),
				paymentAksDetail.getLogicalGrpRef() };

		// define SQL types of the arguments
		int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR, Types.DOUBLE,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER, Types.TIMESTAMP, Types.NUMERIC, Types.TIMESTAMP, Types.DOUBLE, Types.VARCHAR, };

		// execute insert query to insert the data
		// return number of row / rows processed by the executed query
		int row = jdbcTemplate.update(insertpaymentAksDetailQuery, params, types);
		System.out.println(row + " row inserted.");
		return row;
	}

	private String insertPaymentAksDetailQuery() {
		final String insertSql = "INSERT INTO CITI_CNT_PAYMENT_ACK_DETAILS (" + "ack_id, " + "payment_instruction_id, "
				+ "payment_id, " + "ack_status, " + "file_name, " + "org_id, " + "file_status, " + "payment_amount, "
				+ "PAYMENT_CURRENCY_CODE, " + "payment_date, " + "payment_status, " + "ADDITIONAL_INFO, "
				+ "created_by, " + "CREATION_DATE, " + "LAST_UPDATED_BY, " + "LAST_UPDATE_DATE, " + "PAYMENT_NUMBER, "
				+ "LOGICAL_GROUP_REFERENCE) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return insertSql;
	}

	private void readPain002BatchAksFile(Document document, String fileName) throws Exception {
		logger.debug("logger start============= readPain002BatchAksFile starting ===========");
		PaymentBatchAksDetail paymentBatchAksDetail = new PaymentBatchAksDetail();
		if (document.getCstmrPmtStsRpt().getGrpHdr().getMsgId() != null) {
			paymentBatchAksDetail.setPaymentBatchAckID(document.getCstmrPmtStsRpt().getGrpHdr().getMsgId());
		}
		if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getOrgnlMsgId() != null) {
			paymentBatchAksDetail.setPayment_instruction_id(
					new BigDecimal(document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getOrgnlMsgId()));
		}
		if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getGrpSts().value() != null) {
			paymentBatchAksDetail
					.setAck_status(document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getGrpSts().value());
		}
		paymentBatchAksDetail.setFile_name(fileName);
		Date date = new Date();
		paymentBatchAksDetail.setCreated_date(date);
		paymentBatchAksDetail.setUpdated_date(date);
		if (paymentBatchAksDetail.getCreated_by() == null)
			paymentBatchAksDetail.setCreated_by(1000);
		if (paymentBatchAksDetail.getUpdated_by() == null)
			paymentBatchAksDetail.setUpdated_by(1000);

		if (document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getStsRsnInf().get(0).getAddtlInf() != null) {
			String addInfo = document.getCstmrPmtStsRpt().getOrgnlGrpInfAndSts().getStsRsnInf().get(0).getAddtlInf()
					.get(0);
			paymentBatchAksDetail.setAdditional_Info(addInfo);
			if ("ACK - FILE ACCEPTED".contains(addInfo)) {
				paymentBatchAksDetail.setFile_status("ACKNOWLEDGED");
			} else {
				paymentBatchAksDetail.setFile_status("REJECTED");
			}
		} else {
			paymentBatchAksDetail.setFile_status("REJECTED");
		}

		String insertpaymentBatchAksDetail = insertPaymentBatchAksDetailQuery();
		// paymentAksDetailRepository.save(paymentAksDetail);

		int row = saveRecord(insertpaymentBatchAksDetail, paymentBatchAksDetail);
		System.out.print("Insert payment Ack details" + row);
		// paymentBatchAksDetailRepository.save(paymentBatchAksDetail);
		painFiles.add(fileName);
		logger.debug("Files successfully procced::" + painFiles);

	}

	private int saveRecord(String insertpaymentBatchAksDetail, PaymentBatchAksDetail paymentBatchAksDetail) {
		Object[] params = new Object[] { paymentBatchAksDetail.getPaymentBatchAckID(),
				paymentBatchAksDetail.getPayment_instruction_id(), paymentBatchAksDetail.getAck_status(),
				paymentBatchAksDetail.getFile_name(), paymentBatchAksDetail.getCreated_by(),
				paymentBatchAksDetail.getCreated_date(), paymentBatchAksDetail.getUpdated_by(),
				paymentBatchAksDetail.getUpdated_date(), paymentBatchAksDetail.getOrg_id(),
				paymentBatchAksDetail.getFile_status(), paymentBatchAksDetail.getAdditional_Info() };

		int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
				Types.TIMESTAMP, Types.INTEGER, Types.TIMESTAMP, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR };

		int row = jdbcTemplate.update(insertpaymentBatchAksDetail, params, types);
		System.out.println(row + " row inserted.");
		return row;
	}

	private String insertPaymentBatchAksDetailQuery() {
		final String insertSql = "INSERT INTO CITI_CNT_PAYBATCH_ACK_DETAILS (" + "PAYBATCH_ACK_ID, "
				+ "PAYMENT_INSTRUCTION_ID, " + "ACK_STATUS, " + "FILE_NAME, " + "created_by, " + "CREATION_DATE, "
				+ "LAST_UPDATED_BY, " + "LAST_UPDATE_DATE, " + "org_id, " + "file_status, " + "ADDITIONAL_INFO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
		return insertSql;
	}
}
