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

    //    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private String id;
    //    @CsvBindByName(column = "product_id")
    @CsvBindByPosition(position = 1)
    private String product_id;
        @CsvBindByPosition(position = 2)
    private String user_name;
        @CsvBindByPosition(position = 3)
    private String user_id;
        @CsvBindByPosition(position = 4)
    private String title;

    @CsvBindByPosition(position = 5)
    private String message;
    @CsvBindByPosition(position = 6)
    private String score;
    @CsvBindByPosition(position = 7)
    private String image_url1;
    @CsvBindByPosition(position = 8)
    private String image_url2;
    @CsvBindByPosition(position = 9)
    private String image_url3;

    @CsvBindByPosition(position = 10)
    private String image_url4;
    @CsvBindByPosition(position = 11)
    private String display;
    @CsvBindByPosition(position = 12)
    private String created_at;
    @CsvBindByPosition(position = 13)
    private String locale;
    @CsvBindByPosition(position = 14)
    private String social_media_type;

    public Crema(String id, String product_id, String user_name, String user_id, String title, String message, String score, String image_url1, String created_at) {
        this.id = id;
        this.product_id = product_id;
        this.user_name = user_name;
        this.user_id = user_id;
        this.title = title;
        this.message = message;
        this.score = score;
        this.image_url1 = image_url1;
        this.created_at = created_at;
    }

    @CsvBindByPosition(position = 15)
    private String review_source_has_video;
    @CsvBindByPosition(position = 16)
    private String review_source_message;
    @CsvBindByPosition(position = 17)
    private String review_source_title;
    @CsvBindByPosition(position = 18)
    private String review_source_url;
    @CsvBindByPosition(position = 19)
    private String review_source_user_name;

    @CsvBindByPosition(position = 20)
    private String review_source_user_profile_image_url;
    @CsvBindByPosition(position = 21)
    private String comment_author1;
    @CsvBindByPosition(position = 22)
    private String comment_username1;
    @CsvBindByPosition(position = 23)
    private String comment_message1;
    @CsvBindByPosition(position = 24)
    private String comment_created_at1;

    @CsvBindByPosition(position = 25)
    private String comment_author2;
    @CsvBindByPosition(position = 26)
    private String comment_username2;
    @CsvBindByPosition(position = 27)
    private String comment_message2;
    @CsvBindByPosition(position = 28)
    private String comment_created_at2;
    @CsvBindByPosition(position = 29)
    private String comment_author3;

    @CsvBindByPosition(position = 30)
    private String comment_username3;
    @CsvBindByPosition(position = 31)
    private String comment_message3;
    @CsvBindByPosition(position = 32)
    private String comment_created_at3;
    @CsvBindByPosition(position = 33)
    private String comment_author4;
    @CsvBindByPosition(position = 34)
    private String comment_username4;

    @CsvBindByPosition(position = 35)
    private String comment_message4;
    @CsvBindByPosition(position = 36)
    private String comment_created_at4;
    @CsvBindByPosition(position = 37)
    private String comment_author5;
    @CsvBindByPosition(position = 38)
    private String comment_username5;
    @CsvBindByPosition(position = 39)
    private String comment_message5;

    @CsvBindByPosition(position = 40)
    private String comment_created_at5;
    @CsvBindByPosition(position = 41)
    private String comment_author6;
    @CsvBindByPosition(position = 42)
    private String comment_username6;
    @CsvBindByPosition(position = 43)
    private String comment_message6;
    @CsvBindByPosition(position = 44)
    private String comment_created_at6;

    @CsvBindByPosition(position = 45)
    private String comment_author7;
    @CsvBindByPosition(position = 46)
    private String comment_username7;
    @CsvBindByPosition(position = 47)
    private String comment_message7;
    @CsvBindByPosition(position = 48)
    private String comment_created_at7;
    @CsvBindByPosition(position = 49)
    private String comment_author8;

    @CsvBindByPosition(position = 50)
    private String comment_username8;
    @CsvBindByPosition(position = 51)
    private String comment_message8;
    @CsvBindByPosition(position = 52)
    private String comment_created_at8;
    @CsvBindByPosition(position = 53)
    private String comment_author9;
    @CsvBindByPosition(position = 54)
    private String comment_username9;

    @CsvBindByPosition(position = 55)
    private String comment_message9;
    @CsvBindByPosition(position = 56)
    private String comment_created_at9;
    @CsvBindByPosition(position = 57)
    private String comment_author10;
    @CsvBindByPosition(position = 58)
    private String comment_username10;
    @CsvBindByPosition(position = 59)
    private String comment_message10;

    @CsvBindByPosition(position = 60)
    private String comment_created_at10;


}
