package com.jy.sample.filereader.csv.scheduler;

import com.jy.sample.filereader.csv.application.ReviewService;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CsvFileScheduler {

    private final ReviewService reviewService;

    // 일정 시간되면 스케줄링, main 클래스에 @EnableScheduling 어노테이션을 추가해줘야 사용 가능
    // Method는 void 타입으로만 사용하가능하고 매개변수는 사용 불가!
    // scheduler를 사용할 class에 @Component, Method에는 @Scheduled를 추가
//    @Scheduled(cron = "0 15 10 15 * ?", zone = "Asia/Seoul") 매월 15일 오전 10시 15분에 실행
//    @Scheduled(cron = "0 35  22 * * *", zone = "Asia/Seoul")
    public void fileReader() throws IOException, CsvException {
      log.info("스케줄러 실행중");
//      reviewService.readReview();
        reviewService.callReadReview();
    }

    @PostConstruct
    public void csvReadAndWrite() {
        reviewService.csvReadAndWrite();
    }

    /**
     * @Scheduled(fixedDelay = 1000)
     * - 이전 작업이 종료된 후 설정 시간(milleseconds)이후에 다시 시작
     * - 이전 작업이 완료될때까지 대기
     * @Scheduled(fixedRate = 1000)
     * - 고정 시간 간격으로 시작
     * - 이전 작업이 완료될 때까지 다음 작업이 진행되지 않음
     * - 병렬 동작을 사용할 경우 @Async 추가
     * CRON 표현식
     * 초(0-59) | 분(0-59) | 시(0~23) | 일(1-31) | 월(1-12) | 요일(0-7) | 연도(생략가능)
     *
     */
}
