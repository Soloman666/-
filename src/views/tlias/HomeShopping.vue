<template>
    <div>

<el-container>
  <el-header>
     <div >
 <el-carousel :interval="5000" arrow="always" height="200px" width="200px" > 
              <el-carousel-item v-for="img in imgs" :key="img.id">
                
                <img :src = "img.idView"  alt="" >   

                
              </el-carousel-item>
            </el-carousel>

  </div>
  </el-header>
  <el-container>
    
     <el-aside width="230px" style="border: 1px solid #eee">
       <br><br> <br><br> <br><br> <br>
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
    <el-main> 
      <br><br> <br><br> <br><br> 
      <el-form :inline="true" :model="formInline" :rules="rules" class="demo-form-inline">
  <el-form-item label="商品名称">
    <el-input v-model="formInline.good" placeholder="商品名称"></el-input>
  </el-form-item>

  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>
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
           <el-table-column prop="fineness" label="成色" width="200">
          </el-table-column>

           <el-table-column label="操作" width="100">
              <template slot-scope="scope" >
               
                <el-button
                    size="mini"
                    @click="buy(scope.row)"
                  
                    >购买
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
                formInline: {
          good: '',
         
        }, rules: {
        good: [
            { required: true, message: '请输入商品名称!', trigger: 'blur' },
           
          ],},
      
                    imgs: [
                      
                      
                 {id:0,idView: "https://img1.baidu.com/it/u=2145836056,371078144&fm=253&fmt=auto&app=138&f=JPEG?w=1920&h=500"},

                 {id:1,idView:"https://n.sinaimg.cn/spider20240301/410/w900h310/20240301/7a1d-eb7edb9d1a0f8bd245bacd750a06b6aa.png"},
                      
                 { id:2,idView:"https://img.zcool.cn/community/01749f5d609745a8012187f433d6a2.jpg@2o.jpg"},
                      

                   ],
        
      tableData: [],
    };
  },

 
 
    
 
 created() 
{
    axios.get("http://localhost:8081/goods/").then((result) => {
       this.tableData= result.data.data
    });
    
},
methods:{
  onSubmit(){

 axios.get("http://localhost:8081/searchgoodsname/"+this.formInline['good']).then((result) => {
       this.tableData= result.data.data
    });
  },

  buy(row){
       this.$router.push({
        path:'/onshopping',
        query:{number:row.number}
  })
}
}
}

</script>

<style>

.el-header, .el-footer {
    background-color: #f9fafb;
    color: #fcfbfb;
    text-align: center;
    line-height: 70px;
  }
.el-carousel__item img {
    height: 100%;
    width: 90%;
    text-align: center;
}
 
    
  

</style>
