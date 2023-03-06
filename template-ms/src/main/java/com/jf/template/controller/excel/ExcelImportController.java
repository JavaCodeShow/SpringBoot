package com.jf.template.controller.excel;

import com.alibaba.excel.EasyExcel;
import com.jf.model.response.CommonResult;
import com.jf.template.domain.dto.UploadStaffTagExcelVo;
import com.jf.template.domain.dto.UploadStaffTagExcelVoListener;
import com.jf.template.domain.request.UploadFileRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-06-23 11:03
 * @since: 2.27
 */
@RestController
public class ExcelImportController {

    @ApiOperation("API - 导入excel给员工打标签")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult upload(@Validated UploadFileRequest request) {

        List<UploadStaffTagExcelVo> uploadStaffTagExcelVoList = new ArrayList<>();

        try {

            // 上传文件到服务器
            // uploadInfo = fileService.upload(request.getFile(),
            // ModeMeta.STAFF_TAG_EXPORT);
            File file = new File("F:\\media\\upload\\123.xlsx");
            request.getFile().transferTo(file);
            // uploadStaffTagExcelVoList = streamReadEmailSendExcel(
            // file.getAbsolutePath(), sendFileInfo);

            UploadStaffTagExcelVoListener uploadStaffTagExcelVoListener = new UploadStaffTagExcelVoListener();
            EasyExcel
                    .read(file.getAbsolutePath(), UploadStaffTagExcelVo.class,
                            uploadStaffTagExcelVoListener)
                    .sheet().headRowNumber(2).doRead();
            uploadStaffTagExcelVoList = uploadStaffTagExcelVoListener.getList();
        } catch (Exception e) {
            return CommonResult.fail("格式不对");
        }
        System.out.println(uploadStaffTagExcelVoList);

        return CommonResult.success(uploadStaffTagExcelVoList);
    }
}
