package com.emrys.vaipixel.controller;

import com.emrys.vaipixel.db.model.Work;
import com.emrys.vaipixel.exception.VaiException;
import com.emrys.vaipixel.http.request.SubmitWorkRequest;
import com.emrys.vaipixel.http.response.UploadAuthResponse;
import com.emrys.vaipixel.http.response.VaiPixelResponse;
import com.emrys.vaipixel.service.works.IWorksService;
import com.emrys.vaipixel.third.service.IThirdObjectStorageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import static com.emrys.vaipixel.constant.Constant.ErrorStatus.FAIL_REQUEST_PARAM;
import static com.emrys.vaipixel.constant.Constant.ErrorStatus.FAIL_WORK_KEY_ERROR;
import static com.emrys.vaipixel.constant.Constant.Params.*;
import static com.emrys.vaipixel.db.enums.WorkTypeEnum.photo;
import static com.emrys.vaipixel.db.enums.WorkTypeEnum.video;

@RestController
public class WorksController extends BaseV1Controller {

    private IWorksService worksService;

    private IThirdObjectStorageService qiniuCloudService;

    @Autowired
    public WorksController(IWorksService worksService) {
        this.worksService = worksService;
    }

    @Autowired
    public void setQiniuCloudService(IThirdObjectStorageService qiniuCloudService) {
        this.qiniuCloudService = qiniuCloudService;
    }

    @RequestMapping("/works")
    public PageInfo<Work> works(
            @RequestParam(value = KEY_PAGE_NUM, required = false, defaultValue = DEFAULT_PAGE_NUM)
                    int pageNum,
            @RequestParam(value = KEY_PAGE_SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE)
                    int pageSize) {
        return worksService.getWorks(pageNum, pageSize);
    }

    @RequestMapping("/photo/{workId}")
    public Work photoDetail(@PathVariable long workId) {
        return worksService.getWorkDetail(workId, photo);
    }

    @RequestMapping("/video/{workId}")
    public Work videoDetail(@PathVariable long workId) {
        return worksService.getWorkDetail(workId, video);
    }

    @RequestMapping(value = "/work/upload/auth", method = RequestMethod.POST)
    @ResponseBody
    public VaiPixelResponse uploadAuth() {
        String token = qiniuCloudService.getUploadAuth();
        return new UploadAuthResponse(token);
    }

    @RequestMapping(value = "/work/submit", method = RequestMethod.POST)
    @ResponseBody
    public String submitWork(SubmitWorkRequest request) {
        if (request == null) {
            throw VaiException.withStatus(FAIL_REQUEST_PARAM);
        } else if (StringUtils.isEmpty(request.getKey())) {
            throw VaiException.withStatus(FAIL_WORK_KEY_ERROR);
        } else {
            worksService.addWork(request.getKey(), request.getWork());
            return "";
        }
    }

}
