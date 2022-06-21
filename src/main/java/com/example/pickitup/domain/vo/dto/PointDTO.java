package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.Loader;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class PointDTO {
    private String title;
    private Date pointDate;
    private Long point;
    private String category;

    public PointDTO(String title, String pointDate, Long point, String category) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.title = title;
        this.pointDate = format.parse(pointDate);
        this.point = point;
        this.category = category;
    }
}
