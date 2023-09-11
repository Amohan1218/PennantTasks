package com.excel;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.customer.orm.model.LoanApplicant;


public class ExcelGenerator {

	public static Workbook generateExcel(List<LoanApplicant> loanApplicants) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("MS Loan Applicants");

		// Create header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Applicant ID");
		headerRow.createCell(1).setCellValue("Applied date");
		headerRow.createCell(2).setCellValue("Customer ID");
		headerRow.createCell(3).setCellValue("loan amount");
		headerRow.createCell(4).setCellValue("EMI months");
		headerRow.createCell(5).setCellValue("Annual income");
		headerRow.createCell(6).setCellValue("Disposed income");
		headerRow.createCell(7).setCellValue("Status");
		headerRow.createCell(8).setCellValue("Remarks");

		int rowNum = 1;
		for (LoanApplicant applicant : loanApplicants) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(applicant.getId());
			row.createCell(1).setCellValue(applicant.getApplicationDate());
			row.createCell(2).setCellValue(applicant.getCustomerId());
			row.createCell(3).setCellValue(applicant.getLoanAmount());
			row.createCell(4).setCellValue(applicant.getNoOfMonthsRequested());
			row.createCell(5).setCellValue(applicant.getAnnualIncome());
			row.createCell(6).setCellValue(applicant.getDisposableIncome());
			row.createCell(7).setCellValue(applicant.getStatus());
			row.createCell(8).setCellValue(applicant.getConclusionRemarks());
			// Add other data fields as needed
		}

		return workbook;
	}
}