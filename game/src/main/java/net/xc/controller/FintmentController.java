package net.xc.controller;

        import net.xc.pojo.HouseFintment;
        import net.xc.pojo.Warehouse;
        import net.xc.service.HouseFintmentService;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;
        import javax.servlet.http.HttpServletResponse;

@RestController
public class FintmentController {

    @Resource
    private HouseFintmentService houseFintmentService;//业务层


    Warehouse warehouse=new Warehouse();

    @RequestMapping("/showFintment")
    @ResponseBody
    public Object showListFintment() {
        return houseFintmentService.queryFintmentList();
    }

    @RequestMapping(value = "/queryUpataInterByuserid",produces = "application/json;charset=UTF-8")

    public Object queryUpataInterByuserid(Integer user_id, Integer fintment_id, Integer num, HttpServletResponse response){
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        warehouse.setUserId(user_id);
        warehouse.setFintmentId(fintment_id);


        int warByid = houseFintmentService.queryWarByid(warehouse);
        if(warByid==1) {
            warehouse.setNum(num);
            int i = houseFintmentService.updateWarBynum(warehouse);
            return i;
        }

        return houseFintmentService.addWarehouse(warehouse);
    }


}
