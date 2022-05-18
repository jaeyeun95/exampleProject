package com.jy.sample.filereader.csv.application;

import com.jy.sample.filereader.csv.domain.Crema;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {

    // 리뷰 파일 읽기
    /*
        0 index
        1 review_no : 리뷰번호
        2 grade : 평점
        3 cust_no : 고객번호
        4 item_cd : 상품번호
        5 cjmall_id : 상품 번호 // custom_product_code , sellerPrdCode
        6 nickname
        7 subject
        8 contents
        9 img_atch_yn 이미지 사용 여부 -> 1이면 사용, 0이면 미사용
        10 이미지 경로
        11 등록날짜
    */
    public void readReview(int num) throws IOException, CsvException {
        if (num == 3){
            return;
        }
        log.info("리뷰파일 읽기 시작 : {} ", LocalDate.now());
        int number = num;


        String path = "D:\\coding\\study_workspace\\sample\\src\\main\\resources\\csvfiles\\sample\\reviews" + String.valueOf(num) + ".csv";

        CSVReader reader = new CSVReader(new FileReader(path));
//        csv파일 읽을 때 헤더 스킵하기-> https://www.callicoder.com/java-read-write-csv-file-opencsv/
//        CSVReader csvReader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(1).build();

        // 방법 1 배열로 읽기
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {   // row가 끝날때까지 반복
            log.info("idx : {} number : {}", nextLine[0], num);
//            log.info("리뷰 번호 : {}", nextLine[1]);
//            log.info("제목 : {}", nextLine[7]);
        }

        // 방법2 한번에 List에 담기
//        log.info("List로 읽기 ");
//        List<String[]> lines = reader.readAll();
//        lines.forEach(item -> log.info("lines : {}", item));

//        number += 1;
        log.info("end {}", num);
        readReview(num + 1);
    }

    public void callReadReview() throws IOException, CsvException {
//        int num = 1;
        readReview(1);
    }

    public void csvReadAndWrite() throws IOException, CsvException {
        log.info("csv파일 읽고 쓰기");

        int KEY = 123;

        String readPath = "D:\\fiiles\\csv\\test1.csv";
        String writePath = "D:\\fiiles\\crema5.csv";


        CSVReader reader = new CSVReader(new FileReader(readPath));

        List<String[]> lines = reader.readAll();

        log.info("읽어온 데이터 row : {}", lines.size());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writePath), "EUC-KR"));
//        FileWriter writer = new FileWriter(writePath);
//        StatefulBeanToCsv<Crema> beanToCsv = new StatefulBeanToCsvBuilder<Crema>(writer).build();
        StatefulBeanToCsv<Crema> beanToCsv = new StatefulBeanToCsvBuilder<Crema>(bw).build();

        lines.forEach(item -> {
            try {
                beanToCsv.write(List.of(
                        new Crema(item[1], item[4], item[6], item[5], item[7],
                                item[8], item[2], item[10],
                                item[11]
                                )

                ));
            } catch (CsvDataTypeMismatchException e) {
                throw new RuntimeException(e);
            } catch (CsvRequiredFieldEmptyException e) {
                throw new RuntimeException(e);
            }
        });



        bw.close();
//        writer.close();
    }
}
