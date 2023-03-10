package com.jf.mps.user.param;

import com.jf.model.request.BaseParam;
import com.jf.model.request.ParamChecker;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateNameParam extends BaseParam {

    private String id;

    private String name;


    @Override
    public void checkParam() {
        ParamChecker.notBlank(id, "id 不能为空");
        ParamChecker.notBlank(name, "name 不能为空");
    }
}
