package com.itheima.myai.tools;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.itheima.myai.entity.po.Course;
import com.itheima.myai.entity.po.CourseReservation;
import com.itheima.myai.entity.po.School;
import com.itheima.myai.entity.query.CourseQuery;
import com.itheima.myai.service.ICourseReservationService;
import com.itheima.myai.service.ICourseService;
import com.itheima.myai.service.ISchoolService;
import jakarta.annotation.Resource;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class CourseTools {


    @Resource
    private ICourseReservationService courseReservationService;
    @Resource
    private ICourseService courseService;
    @Resource
    private ISchoolService schoolService;


    @Tool(description = "根据条件查询课程。")
    public List<Course> queryCourse(@ToolParam(description = "查询的条件") CourseQuery query) {
        if (query==null){
            return List.of(); // courseService.list();
        }
        QueryChainWrapper<Course> wrapper = courseService.query()
                .eq(query.getType() != null, "type", query.getType())
                .le(query.getEdu() != null, "edu", query.getEdu());
        if (!CollectionUtils.isEmpty(query.getSorts())){
            for (CourseQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true,sort.getAsc(),sort.getField());
            }
        }
        return wrapper.list();
    }

    @Tool(description = "查询所有校区")
    public List<School> querySchool() {
        return schoolService.list();
    }

    @Tool(description = "生成预约单，返回预约单号")
    public Integer createCourseReservation(
            @ToolParam(description = "预约课程") String course,
            @ToolParam(description = "预约校区") String school,
            @ToolParam(description = "学生姓名") String studentName,
            @ToolParam(description = "联系电话") String contactInfo,
            @ToolParam(description = "备注", required = false) String remark) {
        CourseReservation reservation = new CourseReservation();
        reservation.setCourse(course);
        reservation.setSchool(school);
        reservation.setStudentName(studentName);
        reservation.setContactInfo(contactInfo);
        reservation.setRemark(remark);
        courseReservationService.save(reservation);

        return reservation.getId();
    }

}
