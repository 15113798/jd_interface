<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="cookier值" prop="cookierValue">
      <el-input v-model="dataForm.cookierValue" placeholder="cookier值"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="状态1有效2失效" prop="state">
      <el-input v-model="dataForm.state" placeholder="状态1有效2失效"></el-input>
    </el-form-item>
    <el-form-item label="请求次数，用来控制发送短信" prop="count">
      <el-input v-model="dataForm.count" placeholder="请求次数，用来控制发送短信"></el-input>
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
          cookierValue: '',
          updateTime: '',
          state: '',
          count: ''
        },
        dataRule: {
          cookierValue: [
            { required: true, message: 'cookier值不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态1有效2失效不能为空', trigger: 'blur' }
          ],
          count: [
            { required: true, message: '请求次数，用来控制发送短信不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/kzsjdcookier/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cookierValue = data.kZsJdCookier.cookierValue
                this.dataForm.updateTime = data.kZsJdCookier.updateTime
                this.dataForm.state = data.kZsJdCookier.state
                this.dataForm.count = data.kZsJdCookier.count
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
              url: this.$http.adornUrl(`/generator/kzsjdcookier/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cookierValue': this.dataForm.cookierValue,
                'updateTime': this.dataForm.updateTime,
                'state': this.dataForm.state,
                'count': this.dataForm.count
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
