<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="卖家id" prop="shopid">
      <el-input v-model="dataForm.shopid" placeholder="卖家id"></el-input>
    </el-form-item>
    <el-form-item label="卖家昵称" prop="sellerNickname">
      <el-input v-model="dataForm.sellerNickname" placeholder="卖家昵称"></el-input>
    </el-form-item>
    <el-form-item label="店铺标题" prop="sellerTitle">
      <el-input v-model="dataForm.sellerTitle" placeholder="店铺标题"></el-input>
    </el-form-item>
    <el-form-item label="店铺类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="店铺类型"></el-input>
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
    <el-form-item label="运营" prop="operation">
      <el-input v-model="dataForm.operation" placeholder="运营"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号码"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="状态： 0提交" prop="state">
      <el-input v-model="dataForm.state" placeholder="状态： 0提交"></el-input>
    </el-form-item>
    <el-form-item label="管理员id" prop="mid">
      <el-input v-model="dataForm.mid" placeholder="管理员id"></el-input>
    </el-form-item>
    <el-form-item label="锁定时间" prop="lockTime">
      <el-input v-model="dataForm.lockTime" placeholder="锁定时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="淘宝的活动id" prop="taobaoActId">
      <el-input v-model="dataForm.taobaoActId" placeholder="淘宝的活动id"></el-input>
    </el-form-item>
    <el-form-item label="是否合作 1是 2否" prop="isHezuo">
      <el-input v-model="dataForm.isHezuo" placeholder="是否合作 1是 2否"></el-input>
    </el-form-item>
    <el-form-item label="分配状态： 1已分配 2未分配" prop="allot">
      <el-input v-model="dataForm.allot" placeholder="分配状态： 1已分配 2未分配"></el-input>
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
          shopid: '',
          sellerNickname: '',
          sellerTitle: '',
          type: '',
          url: '',
          qq: '',
          weixinName: '',
          operation: '',
          mobile: '',
          remark: '',
          createTime: '',
          state: '',
          mid: '',
          lockTime: '',
          updateTime: '',
          taobaoActId: '',
          isHezuo: '',
          allot: ''
        },
        dataRule: {
          shopid: [
            { required: true, message: '卖家id不能为空', trigger: 'blur' }
          ],
          sellerNickname: [
            { required: true, message: '卖家昵称不能为空', trigger: 'blur' }
          ],
          sellerTitle: [
            { required: true, message: '店铺标题不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '店铺类型不能为空', trigger: 'blur' }
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
          operation: [
            { required: true, message: '运营不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号码不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态： 0提交不能为空', trigger: 'blur' }
          ],
          mid: [
            { required: true, message: '管理员id不能为空', trigger: 'blur' }
          ],
          lockTime: [
            { required: true, message: '锁定时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          taobaoActId: [
            { required: true, message: '淘宝的活动id不能为空', trigger: 'blur' }
          ],
          isHezuo: [
            { required: true, message: '是否合作 1是 2否不能为空', trigger: 'blur' }
          ],
          allot: [
            { required: true, message: '分配状态： 1已分配 2未分配不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kzsseller/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.shopid = data.kZsSeller.shopid
                this.dataForm.sellerNickname = data.kZsSeller.sellerNickname
                this.dataForm.sellerTitle = data.kZsSeller.sellerTitle
                this.dataForm.type = data.kZsSeller.type
                this.dataForm.url = data.kZsSeller.url
                this.dataForm.qq = data.kZsSeller.qq
                this.dataForm.weixinName = data.kZsSeller.weixinName
                this.dataForm.operation = data.kZsSeller.operation
                this.dataForm.mobile = data.kZsSeller.mobile
                this.dataForm.remark = data.kZsSeller.remark
                this.dataForm.createTime = data.kZsSeller.createTime
                this.dataForm.state = data.kZsSeller.state
                this.dataForm.mid = data.kZsSeller.mid
                this.dataForm.lockTime = data.kZsSeller.lockTime
                this.dataForm.updateTime = data.kZsSeller.updateTime
                this.dataForm.taobaoActId = data.kZsSeller.taobaoActId
                this.dataForm.isHezuo = data.kZsSeller.isHezuo
                this.dataForm.allot = data.kZsSeller.allot
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
              url: this.$http.adornUrl(`/generator/kzsseller/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'shopid': this.dataForm.shopid,
                'sellerNickname': this.dataForm.sellerNickname,
                'sellerTitle': this.dataForm.sellerTitle,
                'type': this.dataForm.type,
                'url': this.dataForm.url,
                'qq': this.dataForm.qq,
                'weixinName': this.dataForm.weixinName,
                'operation': this.dataForm.operation,
                'mobile': this.dataForm.mobile,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime,
                'state': this.dataForm.state,
                'mid': this.dataForm.mid,
                'lockTime': this.dataForm.lockTime,
                'updateTime': this.dataForm.updateTime,
                'taobaoActId': this.dataForm.taobaoActId,
                'isHezuo': this.dataForm.isHezuo,
                'allot': this.dataForm.allot
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
