package com.jy.sample.filereader.csv.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crema {

    //    @CsvBindByPosition(position = 0)
    @CsvBindByName(column = "id")
    private String id;
    //    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "product_id")
    private String product_id;
    //    @CsvBindByPosition(position = 2)
    private String user_name;
    //    @CsvBindByPosition(position = 3)
    private String user_id;
    //    @CsvBindByPosition(position = 4)
    private String title;

    private String message;
    private String score;
    private String image_url1;
    private String image_url2;
    private String image_url3;

    private String image_url4;
    private String display;
    private String created_at;
    private String locale;
    private String social_media_type;

    private String review_source_has_video;
    private String review_source_message;
    private String review_source_title;
    private String review_source_url;
    private String review_source_user_name;

    private String review_source_user_profile_image_url;
    private String comment_author1;
    private String comment_username1;
    private String comment_message1;
    private String comment_created_at1;

    private String comment_author2;
    private String comment_username2;
    private String comment_message2;
    private String comment_created_at2;
    private String comment_author3;

    private String comment_username3;
    private String comment_message3;
    private String comment_created_at3;
    private String comment_author4;
    private String comment_username4;

    private String comment_message4;
    private String comment_created_at4;
    private String comment_author5;
    private String comment_username5;
    private String comment_message5;

    private String comment_created_at5;
    private String comment_author6;
    private String comment_username6;
    private String comment_message6;
    private String comment_created_at6;

    private String comment_author7;
    private String comment_username7;
    private String comment_message7;
    private String comment_created_at7;
    private String comment_author8;

    private String comment_username8;
    private String comment_message8;
    private String comment_created_at8;
    private String comment_author9;
    private String comment_username9;

    private String comment_message9;
    private String comment_created_at9;
    private String comment_author10;
    private String comment_username10;
    private String comment_message10;

    private String comment_created_at10;

}
