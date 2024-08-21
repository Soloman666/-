<template>
  <div>
    <el-container style="height: 700px; border: 1px solid #eee">
      <el-header style="font-size: 40px; background-color:   rgb(238, 241, 246)"
        >校园二手交易平台</el-header
      >
      <el-container>
        <el-aside width="230px" style="border: 1px solid #eee">
          <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
              <template slot="title"
                ><i class="el-icon-message"></i>管理</template
              >

              <el-menu-item index="1-1">
                <router-link to="/users">用户管理</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link to="/goods">商品管理</router-link>
              </el-menu-item>
              <el-menu-item index="1-3">
                <router-link to="/orders">订单管理</router-link>
              </el-menu-item>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-message"></i>操作</template
              >

              <el-menu-item index="1-1"> 
                <router-link to="/userlogin">退出登录
                </router-link>
                </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
<el-main>

    <el-row>
  <el-button  round style="color :green" @click="handleAdd">添加</el-button>
          </el-row>

        <el-table :data="tableData" >
       
           <el-table-column prop="sellerid" label="卖家id" width="100">
          </el-table-column>
           <el-table-column prop="selleraccount" label="卖家" width="200">
          </el-table-column>
          <el-table-column prop="goodname" label="商品名称" width="200">
          </el-table-column>
          <el-table-column prop="prize" label="商品价格" width="200">
          </el-table-column>
          <el-table-column prop="place" label="交易地点" width="200">
          </el-table-column>
           <el-table-column prop="fineness" label="成色" width="100">
          </el-table-column>
           

           <el-table-column label="操作" width="100">
              <template slot-scope="scope">
               
                <el-button
                    size="mini"
                    type="danger"
                    @click="goodsDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>
            </el-table-column>


        </el-table>
        <br><br>
        <div class="block">
  <el-pagination
    layout="prev, pager, next"
    :total="1000">
  </el-pagination>
</div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
import axios from 'axios';


export default {
  data() {
    return {
      tableData: [],
    };
  },

 
 
    
 
 mounted() 
{
    axios.get("http://localhost:8081/goods/").then((result) => {
       this.tableData= result.data.data
    });
},

methods:{

handleAdd(){
  this.$router.push('/addgoods')
},

 goodsDelete(index, row) {
      this.$confirm('此操作将永久删除该商品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
           
           axios.delete("http://localhost:8081/goods/" + row['number']).then(() => {

      })
          
          window.history.go(0)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
}
}
}
</script>
<style>
</style>

 
 
    
 
 