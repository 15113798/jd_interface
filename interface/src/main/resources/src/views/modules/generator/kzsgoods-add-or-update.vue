<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="产品链接" prop="goodsUrl">
      <el-input v-model="dataForm.goodsUrl" placeholder="产品链接"></el-input>
    </el-form-item>
    <el-form-item label="商品图片" prop="logoImg">
      <el-input v-model="dataForm.logoImg" placeholder="商品图片"></el-input>
    </el-form-item>
    <el-form-item label="商品名称" prop="title">
      <el-input v-model="dataForm.title" placeholder="商品名称"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="所有者id" prop="mid">
      <el-input v-model="dataForm.mid" placeholder="所有者id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="商品ID-新增" prop="skuid">
      <el-input v-model="dataForm.skuid" placeholder="商品ID-新增"></el-input>
    </el-form-item>
    <el-form-item label="商品单价-新增" prop="unitprice">
      <el-input v-model="dataForm.unitprice" placeholder="商品单价-新增"></el-input>
    </el-form-item>
    <el-form-item label="商品落地页-新增" prop="materialurl">
      <el-input v-model="dataForm.materialurl" placeholder="商品落地页-新增"></el-input>
    </el-form-item>
    <el-form-item label="是否支持运费险(1:是,0:否)-新增" prop="isfreefreightrisk">
      <el-input v-model="dataForm.isfreefreightrisk" placeholder="是否支持运费险(1:是,0:否)-新增"></el-input>
    </el-form-item>
    <el-form-item label="是否包邮(1:是,0:否,2)-新增" prop="isfreeshipping">
      <el-input v-model="dataForm.isfreeshipping" placeholder="是否包邮(1:是,0:否,2)-新增"></el-input>
    </el-form-item>
    <el-form-item label="无线佣金比例-新增" prop="commisionratiowl">
      <el-input v-model="dataForm.commisionratiowl" placeholder="无线佣金比例-新增"></el-input>
    </el-form-item>
    <el-form-item label="PC佣金比例-新增" prop="commisionratiopc">
      <el-input v-model="dataForm.commisionratiopc" placeholder="PC佣金比例-新增"></el-input>
    </el-form-item>
    <el-form-item label="图片地址" prop="imgurl">
      <el-input v-model="dataForm.imgurl" placeholder="图片地址"></el-input>
    </el-form-item>
    <el-form-item label="商家id-新增" prop="vid">
      <el-input v-model="dataForm.vid" placeholder="商家id-新增"></el-input>
    </el-form-item>
    <el-form-item label="一级类目名称-新增" prop="cidname">
      <el-input v-model="dataForm.cidname" placeholder="一级类目名称-新增"></el-input>
    </el-form-item>
    <el-form-item label="一级类目ID-新增" prop="cid">
      <el-input v-model="dataForm.cid" placeholder="一级类目ID-新增"></el-input>
    </el-form-item>
    <el-form-item label="二级类目ID-新增" prop="cid2">
      <el-input v-model="dataForm.cid2" placeholder="二级类目ID-新增"></el-input>
    </el-form-item>
    <el-form-item label="二级类目名称" prop="cid2name">
      <el-input v-model="dataForm.cid2name" placeholder="二级类目名称"></el-input>
    </el-form-item>
    <el-form-item label="三级类目id" prop="cid3">
      <el-input v-model="dataForm.cid3" placeholder="三级类目id"></el-input>
    </el-form-item>
    <el-form-item label="三级类目名称" prop="cid3name">
      <el-input v-model="dataForm.cid3name" placeholder="三级类目名称"></el-input>
    </el-form-item>
    <el-form-item label="商品无线京东价（单价为-1表示未查询到该商品单价）" prop="wlunitprice">
      <el-input v-model="dataForm.wlunitprice" placeholder="商品无线京东价（单价为-1表示未查询到该商品单价）"></el-input>
    </el-form-item>
    <el-form-item label="是否秒杀(1:是,0:否)" prop="isseckill">
      <el-input v-model="dataForm.isseckill" placeholder="是否秒杀(1:是,0:否)"></el-input>
    </el-form-item>
    <el-form-item label="30天引单数量" prop="inordercount">
      <el-input v-model="dataForm.inordercount" placeholder="30天引单数量"></el-input>
    </el-form-item>
    <el-form-item label="店铺ID" prop="shopid">
      <el-input v-model="dataForm.shopid" placeholder="店铺ID"></el-input>
    </el-form-item>
    <el-form-item label="是否自营(1:是,0:否)" prop="isjdsale">
      <el-input v-model="dataForm.isjdsale" placeholder="是否自营(1:是,0:否)"></el-input>
    </el-form-item>
    <el-form-item label="商品名称" prop="goodsname">
      <el-input v-model="dataForm.goodsname" placeholder="商品名称"></el-input>
    </el-form-item>
    <el-form-item label="状态： 1正常 2挖单待处理 3挖单已处理" prop="state">
      <el-input v-model="dataForm.state" placeholder="状态： 1正常 2挖单待处理 3挖单已处理"></el-input>
    </el-form-item>
    <el-form-item label="现在的佣金比率" prop="commissionratenow">
      <el-input v-model="dataForm.commissionratenow" placeholder="现在的佣金比率"></el-input>
    </el-form-item>
    <el-form-item label="分配状态： 1已分配 2未分配" prop="allot">
      <el-input v-model="dataForm.allot" placeholder="分配状态： 1已分配 2未分配"></el-input>
    </el-form-item>
    <el-form-item label="京东活动id（新）" prop="activityid">
      <el-input v-model="dataForm.activityid" placeholder="京东活动id（新）"></el-input>
    </el-form-item>
    <el-form-item label="佣金比例（新）" prop="commissionrate">
      <el-input v-model="dataForm.commissionrate" placeholder="佣金比例（新）"></el-input>
    </el-form-item>
    <el-form-item label="参与时间-开始时间（新）" prop="starttime">
      <el-input v-model="dataForm.starttime" placeholder="参与时间-开始时间（新）"></el-input>
    </el-form-item>
    <el-form-item label="参与时间-结束时间（新）" prop="endtime">
      <el-input v-model="dataForm.endtime" placeholder="参与时间-结束时间（新）"></el-input>
    </el-form-item>
    <el-form-item label="商品图片路径（新）" prop="imageurl">
      <el-input v-model="dataForm.imageurl" placeholder="商品图片路径（新）"></el-input>
    </el-form-item>
    <el-form-item label="引单量（新）" prop="ordercntin">
      <el-input v-model="dataForm.ordercntin" placeholder="引单量（新）"></el-input>
    </el-form-item>
    <el-form-item label="服务费比例（新）" prop="servicerate">
      <el-input v-model="dataForm.servicerate" placeholder="服务费比例（新）"></el-input>
    </el-form-item>
    <el-form-item label="店铺名称（新）" prop="shopname">
      <el-input v-model="dataForm.shopname" placeholder="店铺名称（新）"></el-input>
    </el-form-item>
    <el-form-item label="商品名称（新）" prop="skuname">
      <el-input v-model="dataForm.skuname" placeholder="商品名称（新）"></el-input>
    </el-form-item>
    <el-form-item label="状态（新）0待审核1已通过2已拒绝3已中止4已过期5已停止" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态（新）0待审核1已通过2已拒绝3已中止4已过期5已停止"></el-input>
    </el-form-item>
    <el-form-item label="京东的活动id" prop="taobaoActId">
      <el-input v-model="dataForm.taobaoActId" placeholder="京东的活动id"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          goodsUrl: '',
          logoImg: '',
          title: '',
          price: '',
          mid: '',
          createTime: '',
          updateTime: '',
          skuid: '',
          unitprice: '',
          materialurl: '',
          isfreefreightrisk: '',
          isfreeshipping: '',
          commisionratiowl: '',
          commisionratiopc: '',
          imgurl: '',
          vid: '',
          cidname: '',
          cid: '',
          cid2: '',
          cid2name: '',
          cid3: '',
          cid3name: '',
          wlunitprice: '',
          isseckill: '',
          inordercount: '',
          shopid: '',
          isjdsale: '',
          goodsname: '',
          state: '',
          commissionratenow: '',
          allot: '',
          activityid: '',
          commissionrate: '',
          starttime: '',
          endtime: '',
          imageurl: '',
          ordercntin: '',
          servicerate: '',
          shopname: '',
          skuname: '',
          status: '',
          taobaoActId: ''
        },
        dataRule: {
          goodsUrl: [
            { required: true, message: '产品链接不能为空', trigger: 'blur' }
          ],
          logoImg: [
            { required: true, message: '商品图片不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '商品名称不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          mid: [
            { required: true, message: '所有者id不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          skuid: [
            { required: true, message: '商品ID-新增不能为空', trigger: 'blur' }
          ],
          unitprice: [
            { required: true, message: '商品单价-新增不能为空', trigger: 'blur' }
          ],
          materialurl: [
            { required: true, message: '商品落地页-新增不能为空', trigger: 'blur' }
          ],
          isfreefreightrisk: [
            { required: true, message: '是否支持运费险(1:是,0:否)-新增不能为空', trigger: 'blur' }
          ],
          isfreeshipping: [
            { required: true, message: '是否包邮(1:是,0:否,2)-新增不能为空', trigger: 'blur' }
          ],
          commisionratiowl: [
            { required: true, message: '无线佣金比例-新增不能为空', trigger: 'blur' }
          ],
          commisionratiopc: [
            { required: true, message: 'PC佣金比例-新增不能为空', trigger: 'blur' }
          ],
          imgurl: [
            { required: true, message: '图片地址不能为空', trigger: 'blur' }
          ],
          vid: [
            { required: true, message: '商家id-新增不能为空', trigger: 'blur' }
          ],
          cidname: [
            { required: true, message: '一级类目名称-新增不能为空', trigger: 'blur' }
          ],
          cid: [
            { required: true, message: '一级类目ID-新增不能为空', trigger: 'blur' }
          ],
          cid2: [
            { required: true, message: '二级类目ID-新增不能为空', trigger: 'blur' }
          ],
          cid2name: [
            { required: true, message: '二级类目名称不能为空', trigger: 'blur' }
          ],
          cid3: [
            { required: true, message: '三级类目id不能为空', trigger: 'blur' }
          ],
          cid3name: [
            { required: true, message: '三级类目名称不能为空', trigger: 'blur' }
          ],
          wlunitprice: [
            { required: true, message: '商品无线京东价（单价为-1表示未查询到该商品单价）不能为空', trigger: 'blur' }
          ],
          isseckill: [
            { required: true, message: '是否秒杀(1:是,0:否)不能为空', trigger: 'blur' }
          ],
          inordercount: [
            { required: true, message: '30天引单数量不能为空', trigger: 'blur' }
          ],
          shopid: [
            { required: true, message: '店铺ID不能为空', trigger: 'blur' }
          ],
          isjdsale: [
            { required: true, message: '是否自营(1:是,0:否)不能为空', trigger: 'blur' }
          ],
          goodsname: [
            { required: true, message: '商品名称不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态： 1正常 2挖单待处理 3挖单已处理不能为空', trigger: 'blur' }
          ],
          commissionratenow: [
            { required: true, message: '现在的佣金比率不能为空', trigger: 'blur' }
          ],
          allot: [
            { required: true, message: '分配状态： 1已分配 2未分配不能为空', trigger: 'blur' }
          ],
          activityid: [
            { required: true, message: '京东活动id（新）不能为空', trigger: 'blur' }
          ],
          commissionrate: [
            { required: true, message: '佣金比例（新）不能为空', trigger: 'blur' }
          ],
          starttime: [
            { required: true, message: '参与时间-开始时间（新）不能为空', trigger: 'blur' }
          ],
          endtime: [
            { required: true, message: '参与时间-结束时间（新）不能为空', trigger: 'blur' }
          ],
          imageurl: [
            { required: true, message: '商品图片路径（新）不能为空', trigger: 'blur' }
          ],
          ordercntin: [
            { required: true, message: '引单量（新）不能为空', trigger: 'blur' }
          ],
          servicerate: [
            { required: true, message: '服务费比例（新）不能为空', trigger: 'blur' }
          ],
          shopname: [
            { required: true, message: '店铺名称（新）不能为空', trigger: 'blur' }
          ],
          skuname: [
            { required: true, message: '商品名称（新）不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态（新）0待审核1已通过2已拒绝3已中止4已过期5已停止不能为空', trigger: 'blur' }
          ],
          taobaoActId: [
            { required: true, message: '京东的活动id不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/kzsgoods/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.goodsUrl = data.kZsGoods.goodsUrl
                this.dataForm.logoImg = data.kZsGoods.logoImg
                this.dataForm.title = data.kZsGoods.title
                this.dataForm.price = data.kZsGoods.price
                this.dataForm.mid = data.kZsGoods.mid
                this.dataForm.createTime = data.kZsGoods.createTime
                this.dataForm.updateTime = data.kZsGoods.updateTime
                this.dataForm.skuid = data.kZsGoods.skuid
                this.dataForm.unitprice = data.kZsGoods.unitprice
                this.dataForm.materialurl = data.kZsGoods.materialurl
                this.dataForm.isfreefreightrisk = data.kZsGoods.isfreefreightrisk
                this.dataForm.isfreeshipping = data.kZsGoods.isfreeshipping
                this.dataForm.commisionratiowl = data.kZsGoods.commisionratiowl
                this.dataForm.commisionratiopc = data.kZsGoods.commisionratiopc
                this.dataForm.imgurl = data.kZsGoods.imgurl
                this.dataForm.vid = data.kZsGoods.vid
                this.dataForm.cidname = data.kZsGoods.cidname
                this.dataForm.cid = data.kZsGoods.cid
                this.dataForm.cid2 = data.kZsGoods.cid2
                this.dataForm.cid2name = data.kZsGoods.cid2name
                this.dataForm.cid3 = data.kZsGoods.cid3
                this.dataForm.cid3name = data.kZsGoods.cid3name
                this.dataForm.wlunitprice = data.kZsGoods.wlunitprice
                this.dataForm.isseckill = data.kZsGoods.isseckill
                this.dataForm.inordercount = data.kZsGoods.inordercount
                this.dataForm.shopid = data.kZsGoods.shopid
                this.dataForm.isjdsale = data.kZsGoods.isjdsale
                this.dataForm.goodsname = data.kZsGoods.goodsname
                this.dataForm.state = data.kZsGoods.state
                this.dataForm.commissionratenow = data.kZsGoods.commissionratenow
                this.dataForm.allot = data.kZsGoods.allot
                this.dataForm.activityid = data.kZsGoods.activityid
                this.dataForm.commissionrate = data.kZsGoods.commissionrate
                this.dataForm.starttime = data.kZsGoods.starttime
                this.dataForm.endtime = data.kZsGoods.endtime
                this.dataForm.imageurl = data.kZsGoods.imageurl
                this.dataForm.ordercntin = data.kZsGoods.ordercntin
                this.dataForm.servicerate = data.kZsGoods.servicerate
                this.dataForm.shopname = data.kZsGoods.shopname
                this.dataForm.skuname = data.kZsGoods.skuname
                this.dataForm.status = data.kZsGoods.status
                this.dataForm.taobaoActId = data.kZsGoods.taobaoActId
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/kzsgoods/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'goodsUrl': this.dataForm.goodsUrl,
                'logoImg': this.dataForm.logoImg,
                'title': this.dataForm.title,
                'price': this.dataForm.price,
                'mid': this.dataForm.mid,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'skuid': this.dataForm.skuid,
                'unitprice': this.dataForm.unitprice,
                'materialurl': this.dataForm.materialurl,
                'isfreefreightrisk': this.dataForm.isfreefreightrisk,
                'isfreeshipping': this.dataForm.isfreeshipping,
                'commisionratiowl': this.dataForm.commisionratiowl,
                'commisionratiopc': this.dataForm.commisionratiopc,
                'imgurl': this.dataForm.imgurl,
                'vid': this.dataForm.vid,
                'cidname': this.dataForm.cidname,
                'cid': this.dataForm.cid,
                'cid2': this.dataForm.cid2,
                'cid2name': this.dataForm.cid2name,
                'cid3': this.dataForm.cid3,
                'cid3name': this.dataForm.cid3name,
                'wlunitprice': this.dataForm.wlunitprice,
                'isseckill': this.dataForm.isseckill,
                'inordercount': this.dataForm.inordercount,
                'shopid': this.dataForm.shopid,
                'isjdsale': this.dataForm.isjdsale,
                'goodsname': this.dataForm.goodsname,
                'state': this.dataForm.state,
                'commissionratenow': this.dataForm.commissionratenow,
                'allot': this.dataForm.allot,
                'activityid': this.dataForm.activityid,
                'commissionrate': this.dataForm.commissionrate,
                'starttime': this.dataForm.starttime,
                'endtime': this.dataForm.endtime,
                'imageurl': this.dataForm.imageurl,
                'ordercntin': this.dataForm.ordercntin,
                'servicerate': this.dataForm.servicerate,
                'shopname': this.dataForm.shopname,
                'skuname': this.dataForm.skuname,
                'status': this.dataForm.status,
                'taobaoActId': this.dataForm.taobaoActId
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
