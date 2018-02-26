package com.refeng.service;



import com.refeng.config.DatabaseContextHolder;
import com.refeng.config.DatabaseType;
import com.refeng.mapper.CarouselPicMapper;
import com.refeng.model.CarouselPic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CarouselPicService  {
    @Autowired
    private CarouselPicMapper carouselPicMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * picList;
     * @return
     */
    public List<CarouselPic> picList(){
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        List<CarouselPic> picList=carouselPicMapper.picList();
        return picList;
    }

          //userAdd
        public Integer newsAdd(CarouselPic pic) {
            // TODO Auto-generated method stub
            Integer add = 0;
            pic.setEstablishTime(new Date());
            if (pic.getId() != null) {
                Integer s=pic.getType();
                add = carouselPicMapper.upodatePic(pic);
            } else {


                add = carouselPicMapper.newsPic(pic);

            }
            return add;
        }


    public CarouselPic picById(Integer id){
        CarouselPic picById=carouselPicMapper.picById(id);
        return picById;
    }

}