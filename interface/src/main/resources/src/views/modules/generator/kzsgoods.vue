<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('generator:kzsgoods:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('generator:kzsgoods:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="id">
      </el-table-column>
      <el-table-column
        prop="goodsUrl"
        header-align="center"
        align="center"
        label="产品链接">
      </el-table-column>
      <el-table-column
        prop="logoImg"
        header-align="center"
        align="center"
        label="商品图片">
      </el-table-column>
      <el-table-column
        prop="title"
        header-align="center"
        align="center"
        label="商品名称">
      </el-table-column>
      <el-table-column
        prop="price"
        header-align="center"
        align="center"
        label="价格">
      </el-table-column>
      <el-table-column
        prop="mid"
        header-align="center"
        align="center"
        label="所有者id">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新时间">
      </el-table-column>
      <el-table-column
        prop="skuid"
        header-align="center"
        align="center"
        label="商品ID-新增">
      </el-table-column>
      <el-table-column
        prop="unitprice"
        header-align="center"
        align="center"
        label="商品单价-新增">
      </el-table-column>
      <el-table-column
        prop="materialurl"
        header-align="center"
        align="center"
        label="商品落地页-新增">
      </el-table-column>
      <el-table-column
        prop="isfreefreightrisk"
        header-align="center"
        align="center"
        label="是否支持运费险(1:是,0:否)-新增">
      </el-table-column>
      <el-table-column
        prop="isfreeshipping"
        header-align="center"
        align="center"
        label="是否包邮(1:是,0:否,2)-新增">
      </el-table-column>
      <el-table-column
        prop="commisionratiowl"
        header-align="center"
        align="center"
        label="无线佣金比例-新增">
      </el-table-column>
      <el-table-column
        prop="commisionratiopc"
        header-align="center"
        align="center"
        label="PC佣金比例-新增">
      </el-table-column>
      <el-table-column
        prop="imgurl"
        header-align="center"
        align="center"
        label="图片地址">
      </el-table-column>
      <el-table-column
        prop="vid"
        header-align="center"
        align="center"
        label="商家id-新增">
      </el-table-column>
      <el-table-column
        prop="cidname"
        header-align="center"
        align="center"
        label="一级类目名称-新增">
      </el-table-column>
      <el-table-column
        prop="cid"
        header-align="center"
        align="center"
        label="一级类目ID-新增">
      </el-table-column>
      <el-table-column
        prop="cid2"
        header-align="center"
        align="center"
        label="二级类目ID-新增">
      </el-table-column>
      <el-table-column
        prop="cid2name"
        header-align="center"
        align="center"
        label="二级类目名称">
      </el-table-column>
      <el-table-column
        prop="cid3"
        header-align="center"
        align="center"
        label="三级类目id">
      </el-table-column>
      <el-table-column
        prop="cid3name"
        header-align="center"
        align="center"
        label="三级类目名称">
      </el-table-column>
      <el-table-column
        prop="wlunitprice"
        header-align="center"
        align="center"
        label="商品无线京东价（单价为-1表示未查询到该商品单价）">
      </el-table-column>
      <el-table-column
        prop="isseckill"
        header-align="center"
        align="center"
        label="是否秒杀(1:是,0:否)">
      </el-table-column>
      <el-table-column
        prop="inordercount"
        header-align="center"
        align="center"
        label="30天引单数量">
      </el-table-column>
      <el-table-column
        prop="shopid"
        header-align="center"
        align="center"
        label="店铺ID">
      </el-table-column>
      <el-table-column
        prop="isjdsale"
        header-align="center"
        align="center"
        label="是否自营(1:是,0:否)">
      </el-table-column>
      <el-table-column
        prop="goodsname"
        header-align="center"
        align="center"
        label="商品名称">
      </el-table-column>
      <el-table-column
        prop="state"
        header-align="center"
        align="center"
        label="状态： 1正常 2挖单待处理 3挖单已处理">
      </el-table-column>
      <el-table-column
        prop="commissionratenow"
        header-align="center"
        align="center"
        label="现在的佣金比率">
      </el-table-column>
      <el-table-column
        prop="allot"
        header-align="center"
        align="center"
        label="分配状态： 1已分配 2未分配">
      </el-table-column>
      <el-table-column
        prop="activityid"
        header-align="center"
        align="center"
        label="京东活动id（新）">
      </el-table-column>
      <el-table-column
        prop="commissionrate"
        header-align="center"
        align="center"
        label="佣金比例（新）">
      </el-table-column>
      <el-table-column
        prop="starttime"
        header-align="center"
        align="center"
        label="参与时间-开始时间（新）">
      </el-table-column>
      <el-table-column
        prop="endtime"
        header-align="center"
        align="center"
        label="参与时间-结束时间（新）">
      </el-table-column>
      <el-table-column
        prop="imageurl"
        header-align="center"
        align="center"
        label="商品图片路径（新）">
      </el-table-column>
      <el-table-column
        prop="ordercntin"
        header-align="center"
        align="center"
        label="引单量（新）">
      </el-table-column>
      <el-table-column
        prop="servicerate"
        header-align="center"
        align="center"
        label="服务费比例（新）">
      </el-table-column>
      <el-table-column
        prop="shopname"
        header-align="center"
        align="center"
        label="店铺名称（新）">
      </el-table-column>
      <el-table-column
        prop="skuname"
        header-align="center"
        align="center"
        label="商品名称（新）">
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        label="状态（新）0待审核1已通过2已拒绝3已中止4已过期5已停止">
      </el-table-column>
      <el-table-column
        prop="taobaoActId"
        header-align="center"
        align="center"
        label="京东的活动id">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './kzsgoods-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/kzsgoods/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/generator/kzsgoods/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
