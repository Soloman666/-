<template>
    <div>

<el-container>
  <el-header>Header</el-header>
  <el-container>
     <el-aside width="230px" style="border: 1px solid #eee">
          <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
              <template slot="title"
              ><i class="el-icon-message"></i>管理
              </template>

              <el-menu-item index="1-1">
                <router-link to="/homeshopping">购物</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link to="/homemyorders">我的订单</router-link>
              </el-menu-item>
              <el-menu-item index="1-3">
                <router-link to="/homesellinggoods">出手商品</router-link>
              </el-menu-item>
                <el-menu-item index="1-3">
                <router-link to="/homeundeliveredgoods">未交付商品</router-link>
              </el-menu-item>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-message"></i>操作
              </template
              >

              <el-menu-item index="1-1"> 
                <router-link to="/userlogin">退出登录</router-link>
                </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
    <el-main>  <el-table :data="tableData" >
       
          
           <el-table-column prop="number" label="商品编号" width="300">
          </el-table-column>
          <el-table-column prop="goodname" label="商品名称" width="300">
          </el-table-column>
           <el-table-column prop="fineness" label="成色" width="300">
          </el-table-column>
          
           <el-table-column label="操作" width="300">
              <template slot-scope="scope" >
               
                <el-button
                    size="mini"
                    @click="deliver(scope.$index, scope.row)"
                  
                    >确认已交付
                </el-button>
              </template>
            </el-table-column>
      
      

        </el-table>
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
  methods:{
  deliver(index,row){
       this.$confirm('是否确定已交付此商品?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
           
           axios.put("http://localhost:8081/shopping2/" + row['number']).then(() => {

      })
          
          window.history.go(0)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消交付'
          });          
        });}
            
  },
  

 mounted() 
{
    axios.get("http://localhost:8081/undeliveredgoods").then((result) => {
       this.tableData= result.data.data
    });
}}






</script>


<style>

</style>