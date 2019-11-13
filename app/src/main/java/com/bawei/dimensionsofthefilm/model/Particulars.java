package com.bawei.dimensionsofthefilm.model;

import java.util.List;

/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇*/
public class Particulars {
     /*     "commentNum": 30,
                  "duration": "148分钟",
                  "imageUrl": "http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg",
                  "movieActor": [


                        "movieId": 16,
        "movieType": "动作 / 冒险 / 惊悚",
        "name": "碟中谍6：全面瓦解",
        "placeOrigin": "美国",

            "releaseTime": 1600704000000,
        "score": 8.9,

             "summary": "有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。",
        "whetherFollow": 2

                  */


     public int commentNum;
     public String  duration;
     public String imageUrl;
     public int movieId;
     public String movieType;
     public String name;
     public String placeOrigin;
     public long releaseTime;
     public double score;
     public String summary;
     public int whetherFollow;

     public List<MovieActor> movieActor ;
     public List<MovieDirector> movieDirector ;
     public List<String> posterList ;
     public List<ShortFilmList> shortFilmList ;

     @Override
     public String toString() {
          return "Particulars{" +
                  "commentNum=" + commentNum +
                  ", duration='" + duration + '\'' +
                  ", imageUrl='" + imageUrl + '\'' +
                  ", movieId=" + movieId +
                  ", movieType='" + movieType + '\'' +
                  ", name='" + name + '\'' +
                  ", placeOrigin='" + placeOrigin + '\'' +
                  ", releaseTime=" + releaseTime +
                  ", score=" + score +
                  ", summary='" + summary + '\'' +
                  ", whetherFollow=" + whetherFollow +
                  ", movieActor=" + movieActor +
                  ", movieDirector=" + movieDirector +
                  ", posterList=" + posterList +
                  ", shortFilmList=" + shortFilmList +
                  '}';
     }
}
