//package com.jy.sample.filereader.csv.application;
//
//import com.amazonaws.services.kms.model.NotFoundException;
//import com.celebshp.scheduler.common.api.*;
//import com.celebshp.scheduler.domain.*;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVWriter;
//import com.opencsv.bean.StatefulBeanToCsv;
//import com.opencsv.bean.StatefulBeanToCsvBuilder;
//import com.opencsv.exceptions.CsvDataTypeMismatchException;
//import com.opencsv.exceptions.CsvException;
//import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
//import com.opencsv.exceptions.CsvValidationException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
//
//import java.io.*;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import static com.celebshp.scheduler.common.Utils.setApiRequestEntity;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class ReviewService {
//
//    private final CjenmReviewRepository cjenmReviewRepository;
//    private final ProductInfoRepository productInfoRepository;
//    private final ApiRequest apiRequest;
//    private final Cafe24Token cafe24Token;
//    private final DefaultCommonApiImpl defaultCommonApi;
//
//    @Value("${cafe24.mall_id}")
//    private String mallId;
//
//    @Value("${cafe24.review}")
//    private String reviewUrl;
//
//    @Value("${cafe24.review_delete}")
//    private String reviewDeleteUrl;
//
//    @Value("${cafe24.review_list}")
//    private String reviewListUrl;
//
//
//    public void insertReview() throws IOException, CsvValidationException, InterruptedException {
//        String path = "/Users/kimjaeyun/Downloads/review_v1/test8.csv";
//
////        ClassPathResource resource = new ClassPathResource("review/new_review3.csv");
//
//        // csv ?????? ????????????
////        CSVReader reader = new CSVReader(new FileReader(resource.getFile()));
//        CSVReader reader = new CSVReader(new FileReader(path));
//
//        String[] nextLine;
//        List<BoardReq.Requests> list = new ArrayList<>();
//        List<CjenmReview> cjenmReviewList = new ArrayList<>();
////    0
////    1     review_no : ????????????
////    2     grade : ??????        // rating
////    3     cust_no : ????????????    ?
////    4     item_cd : ????????????    // sellerPrdCode, custom_product_code
////    5     cjmall_id :         //  member_id
////    6     nickname            // writer, nick_name
////    7     subject : ??????        // title
////    8     contents : ????????????     // content
////    9     img_atch_yn ????????? ?????? ?????? 1?????? ??????, 0?????? ????????????//    9     imgName  ex) http://itemimage.cjonstyle.net/cjupload/valbbs_img/200805009028_20160116205929_1.jpg
////    10    ????????? ??????
////    11    ????????????
//
//        BoardReq boardReq = BoardReq.builder().build();
////        reader.skip(56569);
//
////        CjenmReview cjenmReview = cjenmReviewRepository.findFirstByReviewNo("212901023");
////        log.info("## cjenmReview : {}  ", cjenmReview.toString());
//
//
//        int count = 1;
//        List<ProductInfo> productInfoList = productInfoRepository.findAll();
////        ExecutorService executor = Executors.newS
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//
//        List<String[]> nextLines = new ArrayList<>();
//
//
//        while ((nextLine = reader.readNext()) != null) {   // 2
//            nextLines.add(nextLine);
//
//            log.info(" idx {}", nextLine[0]);
//
////            CjenmReview cjenmReview = cjenmReviewRepository.findFirstByReviewNo(nextLine[1]);
////            cjenmReview.update("N");
////            cjenmReviewRepository.save(cjenmReview);
//
//            try {
//                if (nextLines.size() % 100 == 0) {
//                    List<String[]> finalNextLines = nextLines;
//                    Runnable runnable = new Runnable() {
//                        @Override
//                        public void run() {
//                            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
//                            int poolSize = threadPoolExecutor.getPoolSize();
//                            String threadName = Thread.currentThread().getName();
//
//                            System.out.println("[??? ????????? ??????:" + poolSize + "] ?????? ????????? ??????: " + threadName);
////                            insertReviews(list, cjenmReviewList);
//                            reviews(finalNextLines, productInfoList);
//                        }
//                    };
//                    executor.execute(runnable);
//
//                    nextLines = new ArrayList<>();
//                    if (count % 4 == 0) {
//                        try {
//                            Thread.sleep(2000);
//                        } catch (Exception e) {
//
//                        }
//                    }
//                    count++;
//
//                }
//            } catch (Exception e) {
//
//            }
//
//        }
//
//
//    }
//
//    public void reviews(List<String[]> nextLines, List<ProductInfo> productInfoList) {
//        log.info("start");
//        List<BoardReq.Requests> list = new ArrayList<>();
//
//        nextLines.forEach(nextLine -> {
//            // ????????? ?????? ???????????? ??????
//            CjenmReview cjenmReview = cjenmReviewRepository.findFirstByReviewNoAndResult(nextLine[1], "N");
//            if (cjenmReview == null){   // result = 'N' ??? ????????? ????????? ??????
//                log.info("?????? ????????? ??????.");
//                return;
//            }
//            // ????????? ?????? ????????? ?????? customProductCode ??? cjenmReview.getCustomProductCode()
//            String customProductCode = cjenmReview.getCustomProductCode();
////            String customProductCode = nextLine[4];
//
////            if (customProductCode != null){
//                ProductInfo productInfo = productInfoList.stream().filter(item ->
//                        item.getCustomProductCode().equals(customProductCode)
//                ).findFirst().orElse(null);
//
//                // ????????? ?????? ????????? pass
//                if (productInfo != null) {
//
//                    log.info("???????????? ???");
//
//                    BoardReq.Requests requests = new BoardReq.Requests();
//
//
//                    if (nextLine[5].equals("***")) {
//                        requests.setMember_id(nextLine[6].charAt(0) + nextLine[5]);
//                    } else {
//                        requests.setMember_id(nextLine[5]);
//                    }
//
//                    requests.setReview_no(nextLine[1]);
//                    requests.setRating((int) Double.parseDouble(nextLine[2]));
//                    requests.setProduct_no(productInfo.getProductNo());
//                    requests.setWriter(nextLine[6]);
//                    requests.setNick_name(nextLine[6]);
//                    requests.setTitle(nextLine[7]);
//                    requests.setContent(nextLine[8]);
//                    requests.setCreated_date(nextLine[11]);
//
//                    //  todo nextLine[9] NPE
//                    if ((int) Double.parseDouble(nextLine[9]) == 1) {
////                    attachFileUrls.setUrl(nextLine[10]);
////                    attachFileUrls.setName(
////                            nextLine[10].substring(nextLine[10].lastIndexOf("/")).replace("/", ""));
//
//                        BoardReq.Requests.AttachFileUrls attachFileUrls = BoardReq.Requests.AttachFileUrls.builder()
//                                .url(nextLine[10])
//                                .name(nextLine[10].substring(nextLine[10].lastIndexOf("/")).replace("/", ""))
//                                .build();
//                        requests.getAttach_file_urls().add(attachFileUrls);
//
//                    }
//
//                    list.add(requests);
//                }
////            } // if (customProductCode != null) end
//
//
//        });
//
//        log.info("####### size {}", list.size());
//        log.info("#### END ");
//
//        int chunk = 10;
//        int pos = 0;
//
//        if (list.size() == 0) {
//            return;
//        }
//
//        while (true) {
//            List<BoardReq.Requests> reviews = new ArrayList<>();
//            if (list.size() >= 10) {
//                IntStream.range(pos, pos + chunk).forEach(idx -> {
//                    reviews.add(list.get(idx));
//                });
//
//                //todo call cafe24 api with reviews
////                cafe24InsertReview(list);
//                cafe24InsertReview(reviews);
//
////                pos += chunk;
//                list.removeAll(reviews);
//            } else {
//                //todo call cafe24 api with list
////                cafe24InsertReview(reviews);
//                cafe24InsertReview(list);
//                list.removeAll(list);
//
//            }
//
//            if (list.isEmpty()) {
//                break;
//            }
//        }
//
//        log.info("end");
//    }
//
//    public void cafe24InsertReview(List<BoardReq.Requests> boardReq) {
//        Review review = Review.getInstance();
//
//        List<BoardReq.Requests> distinctList = boardReq.stream().distinct().collect(Collectors.toList());
//        distinctList = review.check(distinctList);
//
//        BoardReq request = BoardReq.builder()
//                .requests(distinctList)
//                .build();
//
//
//        log.info(request.convert());
//
//
//        ResponseEntity<Map<String, List<Map<String, Object>>>> response = insertReviewCafe24(request);
//
//        log.info("## response : {}, size {}", response.getStatusCodeValue(), distinctList.size());
////
//        for (int i = 0; i < distinctList.size(); i++) {
//            CjenmReview cjenmReview = cjenmReviewRepository.findFirstByReviewNo(distinctList.get(i).getReview_no());
//            cjenmReview.update("Y");
//            cjenmReviewRepository.save(cjenmReview);
//        }
//
//        review.add(distinctList);
//
//
//        log.info("cafe24 ?????? ??????");
//
//
//    }
//
//    //    @Async
//    public ResponseEntity<Map<String, List<Map<String, Object>>>> insertReviewCafe24(BoardReq boardReq) {
//
//        ApiRequestEntity apiRequestEntity = setApiRequestEntity(reviewUrl, boardReq.convert());
//
//        ResponseEntity<Map<String, List<Map<String, Object>>>> response = cafe24Call(apiRequestEntity);
//
//        return response;
//    }
//
//
//    private ResponseEntity<Map<String, List<Map<String, Object>>>> cafe24Call(ApiRequestEntity<Object> apiRequestEntity) {
//
//        String token = cafe24Token.getToken();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setBearerAuth(token);
//        httpHeaders.set("Content-Type", "application/json");
//
//        apiRequestEntity.setHttpHeaders(httpHeaders);
////    Map<String, Object> body;
//        ResponseEntity<Map<String, List<Map<String, Object>>>> body = null;
//
//        try {
//            body = send(apiRequestEntity);
//        } catch (HttpClientErrorException e) {
//
//            if (e.getStatusCode().value() == 401) {
//                token = cafe24Token.updateToken();
//                httpHeaders.setBearerAuth(token);
//                body = send(apiRequestEntity);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // token ????????? ????????? ??????
//        }
//
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//
//        }
//
//        return body;
//
//    }
//
//    private ResponseEntity<Map<String, List<Map<String, Object>>>> send(ApiRequestEntity<Object> apiRequestEntity) {
//        ResponseEntity<Map<String, List<Map<String, Object>>>> response = null;
//
//        response = apiRequest.post(apiRequestEntity);
//
//        return response;
//    }
//
//    public void deleteReview() {
//        log.info("## ?????? list {}", reviewListUrl);
//        log.info("## ?????? delete {}", reviewDeleteUrl);
//
////        while (true){
////            List<Integer> reviewNoList = new ArrayList<>();
////            // ??????????????????
////            Map<String, List<Map<String, Object>>> reviewList = getReviews();
////
////            for (int i = 0; i < reviewList.get("articles").size(); i++) {
////                reviewNoList.add((Integer) reviewList.get("articles").get(i).get("article_no"));
////            }
////
////            System.out.println("### reviewList" + reviewList.toString() );
////
////            reviewDelete(reviewNoList);
////
////            if ( reviewList.get("articles").size() == 0){
////                break;
////            }
////
////        }
//
//
////        log.info("reviewNoList : " + reviewNoList.toString());
////        reviewDelete(reviewNoList);
//
//
//    }
//
//    private void reviewDelete(List<Integer> reviewNoList) {
////      https://cjenmvertical.cafe24api.com/api/v2/admin/boards/4/articles/{article_no}
//
//        for (int i = 0; i < reviewNoList.size(); i++) {
//            ApiRequestEntity apiRequestEntity = setApiRequestEntity(
//                    reviewDeleteUrl.replace("{article_no}", String.valueOf(reviewNoList.get(i))), null);
//
//            Map<String, List<Map<String, Object>>> response = defaultCommonApi.delete(apiRequestEntity, ApiStatus.CAFE24);
//
//            log.info("?????? : {}", response.toString());
//        }
//
//    }
//
//    private Map<String, List<Map<String, Object>>> getReviews() {
//
//        ApiRequestEntity apiRequestEntity = setApiRequestEntity(reviewListUrl, null);
//
//        Map<String, List<Map<String, Object>>> response = defaultCommonApi.get(apiRequestEntity, ApiStatus.CAFE24);
//
//        return response;
//    }
//
//
//
//    public void readReview() throws IOException, CsvValidationException {
//        String path = "/Users/kimjaeyun/Downloads/review_v1/test8.csv";
//
//        // csv ?????? ????????????
////    0
////    1     review_no : ????????????
////    2     grade : ??????        // rating
////    3     cust_no : ????????????    ?
////    4     item_cd : ????????????    // sellerPrdCode, custom_product_code
////    5     cjmall_id :         //  member_id
////    6     nickname            // writer, nick_name
////    7     subject : ??????        // title
////    8     contents : ????????????     // content
////    9     img_atch_yn ????????? ?????? ?????? 1?????? ??????, 0?????? ????????????//    9     imgName  ex) http://itemimage.cjonstyle.net/cjupload/valbbs_img/200805009028_20160116205929_1.jpg
////    10    ????????? ??????
//        // csv ?????? ????????????
//        CSVReader reader = new CSVReader(new FileReader(path));
////        reader.skip(66391);
//
//        String[] nextLine;
//
//            while ((nextLine = reader.readNext()) != null) {   // 2
////                if (nextLine.length > 11){
////                    System.out.println("##### 11 ??????");
////                    continue;
////                }
//                System.out.println("#### : " + nextLine[0]);
//                System.out.println("?????? ?????? : " + nextLine[1]);
//                System.out.println("?????? ?????? : " + nextLine[4]);
//                System.out.println("?????? : " + nextLine[7]);
//                System.out.println("?????? : " + nextLine[11]);
//
////                CjenmReview cafe24Review = CjenmReview.builder()
////                        .reviewNo(nextLine[1])
////                        .customProductCode(nextLine[4])
////                        .result("N")
////                        .build();
//////
////                cjenmReviewRepository.save(cafe24Review);
//
//
//            }
//
//
//
//
//    }
//
//    public void convertTocrema() throws IOException, CsvException {
//        log.info("csv?????? ?????????");
//
////        ?????? ?????? ?????? : /Users/kimjaeyun/Downloads/crema
//        String path = "/Users/kimjaeyun/Downloads/crema/crema.csv";
//        String readFilePath = "/Users/kimjaeyun/Downloads/review_v1/cjreview.csv";
//
//        CSVReader reader = new CSVReader(new FileReader(readFilePath));
//
//        String[] nextLine;
//        List<String[]> lines = reader.readAll();
//
//        FileWriter writer = new FileWriter(path);
//        StatefulBeanToCsv<Crema> beanToCsv = new StatefulBeanToCsvBuilder<Crema>(writer).build();
//
//        lines.forEach(item -> {
//            try {
//                beanToCsv.write(List.of(
//                        new Crema(item[1], item[4], item[6], item[5], item[7],
//                                item[8], item[2], item[10], "", "",
//                                "", "", item[11], "", "",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "","","","","",
//                                "")
//
//                ));
//            } catch (CsvDataTypeMismatchException e) {
//                throw new RuntimeException(e);
//            } catch (CsvRequiredFieldEmptyException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//
//        writer.close();
//
//
//
//
//    }
//}
