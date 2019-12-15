package com.murataydin.app.kotlinmovielist.service

import com.murataydin.app.kotlinmovielist.core.BaseCallBack

class ApiCallback<T>(baseCallBack: BaseCallBack<T>?) : BaseRetrofitCallback<T>(baseCallBack)
