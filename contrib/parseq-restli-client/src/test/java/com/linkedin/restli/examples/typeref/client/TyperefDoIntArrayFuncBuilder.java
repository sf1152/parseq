
package com.linkedin.restli.examples.typeref.client;

import javax.annotation.Generated;
import com.linkedin.data.template.IntegerArray;
import com.linkedin.restli.client.RestliRequestOptions;
import com.linkedin.restli.client.base.ActionRequestBuilderBase;
import com.linkedin.restli.common.ResourceSpec;

@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Request Builder", date = "Thu Mar 31 14:16:24 PDT 2016")
public class TyperefDoIntArrayFuncBuilder
    extends ActionRequestBuilderBase<Void, IntegerArray, TyperefDoIntArrayFuncBuilder>
{


    public TyperefDoIntArrayFuncBuilder(String baseUriTemplate, Class<IntegerArray> returnClass, ResourceSpec resourceSpec, RestliRequestOptions requestOptions) {
        super(baseUriTemplate, returnClass, resourceSpec, requestOptions);
        super.name("IntArrayFunc");
    }

    public TyperefDoIntArrayFuncBuilder paramArg1(IntegerArray value) {
        super.setReqParam(_resourceSpec.getRequestMetadata("IntArrayFunc").getFieldDef("arg1"), value);
        return this;
    }

}
