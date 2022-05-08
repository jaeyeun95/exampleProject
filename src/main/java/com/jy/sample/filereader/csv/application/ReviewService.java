package com.jy.sample.filereader.csv.application;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

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
    public void readReview() throws IOException, CsvValidationException {
        log.info("리뷰파일 읽기 시작 : {} ", LocalDate.now());

        String path = "D:\\coding\\study_workspace\\sample\\src\\main\\resources\\csvfiles\\sample\\reviews1.csv";

        CSVReader reader = new CSVReader(new FileReader(path));

        String[] nextLine;  // csv 파일 row   ->

        while ( (nextLine = reader.readNext()) != null) {   // row가 끝날때까지 반복

        }



    }
}
