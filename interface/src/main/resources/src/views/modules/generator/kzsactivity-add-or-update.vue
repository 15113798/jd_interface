<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型"></el-input>
    </el-form-item>
    <el-form-item label="活动标题" prop="activityTitle">
      <el-input v-model="dataForm.activityTitle" placeholder="活动标题"></el-input>
    </el-form-item>
    <el-form-item label="活动场景类型: 1普通招商" prop="senceType">
      <el-input v-model="dataForm.senceType" placeholder="活动场景类型: 1普通招商"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="" prop="remark">
      <el-input v-model="dataForm.remark" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="操作人id" prop="mid">
      <el-input v-model="dataForm.mid" placeholder="操作人id"></el-input>
    </el-form-item>
    <el-form-item label="联盟账号id" prop="allianceId">
      <el-input v-model="dataForm.allianceId" placeholder="联盟账号id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="状态: 0关闭 1开启" prop="state">
      <el-input v-model="dataForm.state" placeholder="状态: 0关闭 1开启"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="店铺链接" prop="url">
      <el-input v-model="dataForm.url" placeholder="店铺链接"></el-input>
    </el-form-item>
    <el-form-item label="qq" prop="qq">
      <el-input v-model="dataForm.qq" placeholder="qq"></el-input>
    </el-form-item>
    <el-form-item label="微信号" prop="weixinName">
      <el-input v-model="dataForm.weixinName" placeholder="微信号"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号码"></el-input>
    </el-form-item>
    <el-form-item label="是否合作 1是 2否" prop="isHezuo">
      <el-input v-model="dataForm.isHezuo" placeholder="是否合作 1是 2否"></el-input>
    </el-form-item>
    <el-form-item label="京东的活动id" prop="taobaoActId">
      <el-input v-model="dataForm.taobaoActId" placeholder="京东的活动id"></el-input>
    </el-form-item>
    <el-form-item label="分配状态： 1已分配 2未分配" prop="allot">
      <el-input v-model="dataForm.allot" placeholder="分配状态： 1已分配 2未分配"></el-input>
    </el-form-item>
    <el-form-item label="提报商品数量(新)" prop="skucnt">
      <el-input v-model="dataForm.skucnt" placeholder="提报商品数量(新)"></el-input>
    </el-form-item>
    <el-form-item label="订单引入量（新）" prop="ordercntin">
      <el-input v-model="dataForm.ordercntin" placeholder="订单引入量（新）"></el-input>
    </el-form-item>
    <el-form-item label="实际服务费（新）" prop="servicefee">
      <el-input v-model="dataForm.servicefee" placeholder="实际服务费（新）"></el-input>
    </el-form-item>
    <el-form-item label="预估服务费（新）" prop="ygservicefee">
      <el-input v-model="dataForm.ygservicefee" placeholder="预估服务费（新）"></el-input>
    </el-form-item>
    <el-form-item label="活动状态(2为进行中，5为活动结束）" prop="activitystatus">
      <el-input v-model="dataForm.activitystatus" placeholder="活动状态(2为进行中，5为活动结束）"></el-input>
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
          type: '',
          activityTitle: '',
          senceType: '',
          startTime: '',
          endTime: '',
          remark: '',
          mid: '',
          allianceId: '',
          createTime: '',
          state: '',
          updateTime: '',
          url: '',
          qq: '',
          weixinName: '',
          mobile: '',
          isHezuo: '',
          taobaoActId: '',
          allot: '',
          skucnt: '',
          ordercntin: '',
          servicefee: '',
          ygservicefee: '',
          activitystatus: ''
        },
        dataRule: {
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          activityTitle: [
            { required: true, message: '活动标题不能为空', trigger: 'blur' }
          ],
          senceType: [
            { required: true, message: '活动场景类型: 1普通招商不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          mid: [
            { required: true, message: '操作人id不能为空', trigger: 'blur' }
          ],
          allianceId: [
            { required: true, message: '联盟账号id不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态: 0关闭 1开启不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          url: [
            { required: true, message: '店铺链接不能为空', trigger: 'blur' }
          ],
          qq: [
            { required: true, message: 'qq不能为空', trigger: 'blur' }
          ],
          weixinName: [
            { required: true, message: '微信号不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号码不能为空', trigger: 'blur' }
          ],
          isHezuo: [
            { required: true, message: '是否合作 1是 2否不能为空', trigger: 'blur' }
          ],
          taobaoActId: [
            { required: true, message: '京东的活动id不能为空', trigger: 'blur' }
          ],
          allot: [
            { required: true, message: '分配状态： 1已分配 2未分配不能为空', trigger: 'blur' }
          ],
          skucnt: [
            { required: true, message: '提报商品数量(新)不能为空', trigger: 'blur' }
          ],
          ordercntin: [
            { required: true, message: '订单引入量（新）不能为空', trigger: 'blur' }
          ],
          servicefee: [
            { required: true, message: '实际服务费（新）不能为空', trigger: 'blur' }
          ],
          ygservicefee: [
            { required: true, message: '预估服务费（新）不能为空', trigger: 'blur' }
          ],
          activitystatus: [
            { required: true, message: '活动状态(2为进行中，5为活动结束）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kzsactivity/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.type = data.kZsActivity.type
                this.dataForm.activityTitle = data.kZsActivity.activityTitle
                this.dataForm.senceType = data.kZsActivity.senceType
                this.dataForm.startTime = data.kZsActivity.startTime
                this.dataForm.endTime = data.kZsActivity.endTime
                this.dataForm.remark = data.kZsActivity.remark
                this.dataForm.mid = data.kZsActivity.mid
                this.dataForm.allianceId = data.kZsActivity.allianceId
                this.dataForm.createTime = data.kZsActivity.createTime
                this.dataForm.state = data.kZsActivity.state
                this.dataForm.updateTime = data.kZsActivity.updateTime
                this.dataForm.url = data.kZsActivity.url
                this.dataForm.qq = data.kZsActivity.qq
                this.dataForm.weixinName = data.kZsActivity.weixinName
                this.dataForm.mobile = data.kZsActivity.mobile
                this.dataForm.isHezuo = data.kZsActivity.isHezuo
                this.dataForm.taobaoActId = data.kZsActivity.taobaoActId
                this.dataForm.allot = data.kZsActivity.allot
                this.dataForm.skucnt = data.kZsActivity.skucnt
                this.dataForm.ordercntin = data.kZsActivity.ordercntin
                this.dataForm.servicefee = data.kZsActivity.servicefee
                this.dataForm.ygservicefee = data.kZsActivity.ygservicefee
                this.dataForm.activitystatus = data.kZsActivity.activitystatus
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
              url: this.$http.adornUrl(`/generator/kzsactivity/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'type': this.dataForm.type,
                'activityTitle': this.dataForm.activityTitle,
                'senceType': this.dataForm.senceType,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'remark': this.dataForm.remark,
                'mid': this.dataForm.mid,
                'allianceId': this.dataForm.allianceId,
                'createTime': this.dataForm.createTime,
                'state': this.dataForm.state,
                'updateTime': this.dataForm.updateTime,
                'url': this.dataForm.url,
                'qq': this.dataForm.qq,
                'weixinName': this.dataForm.weixinName,
                'mobile': this.dataForm.mobile,
                'isHezuo': this.dataForm.isHezuo,
                'taobaoActId': this.dataForm.taobaoActId,
                'allot': this.dataForm.allot,
                'skucnt': this.dataForm.skucnt,
                'ordercntin': this.dataForm.ordercntin,
                'servicefee': this.dataForm.servicefee,
                'ygservicefee': this.dataForm.ygservicefee,
                'activitystatus': this.dataForm.activitystatus
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
