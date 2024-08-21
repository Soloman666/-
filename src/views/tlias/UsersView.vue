<template>
  <div>
    <el-container style="height: 700px; border: 1px solid #eee">
      <el-header style="font-size: 40px; background-color: rgb(238, 241, 246)"
      >校园二手交易平台
      </el-header
      >
      <el-container>
        <el-aside width="230px" style="border: 1px solid #eee">
          <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
              <template slot="title"
              ><i class="el-icon-message"></i>管理
              </template>

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
           <el-row>
  <el-button  round style="color :green" @click="handleAdd">添加</el-button>
          </el-row>

          <el-table :data="tableData">
             <el-table-column prop="id" label="id" width="100">
            </el-table-column>
            <el-table-column prop="account" label="账号" width="250">
            </el-table-column>
            <el-table-column prop="password" label="密码" width="250">
            </el-table-column>
            <el-table-column prop="grade" label="年级" width="100">
            </el-table-column>
            <el-table-column prop="balance" label="余额" width="250">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    @click="handleEdit(scope.row)">编辑
                </el-button>
                <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除
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

  mounted() {
    axios.get("http://localhost:8081/users").then((result) => {
      this.tableData = result.data.data
    })


//    axios.delete("http://localhost:8081/users/{{account}}", { params: "account " }).then((result) =>{
//       this.tableData= result.data.data
//
// })
  },


  methods: {
   handleAdd(){
this.$router.push('/addusers')


},
    handleDelete(index, row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
           
           axios.delete("http://localhost:8081/users/" + row['id'],).then(() => {

      })
          
          window.history.go(0)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });


     
    },
    handleEdit(row){
      this.$router.push({
        path:'/addusers',
        query:{id:row.id}

      })
      

    }
  }


//       console.log(account)
//      axios.delete("http://localhost:8081/users/{{account}}").then((result) =>{
// alert(result.code)


//   this.tableData= result.data.data
//  this.tableData= result.data.data


//  methods: {
//   handleDelete(index,row){

//     request({
//       method:'delete',
//       URL:'http://localhost:8081/users/{{account}}'
//     }).then((result)=>{
//   this.tableData= result.data.data
//     })
//   }

//   handleEdit(index, row) {
//     console.log(index, row);
//   },
//  handleAdd(){
//     let params = new URLSearchParams();
//     params.append("sname",this.form.sname)
//     params.append("score",this.form.score)
//     axios({
//         methods:"DELETE",
//         url:"http:..127.0.0.1:8000/myapp/add"
//         data:params
//     }).then((res)=>{
//            this.tableData = res.data.data;
//             this.addDialogFormVisible = false
//             this.form = {sname:"",score:""}
//     }).catch((res)=>{});
// }


// methods: {deletaData(){
// axios.delete("http://localhost:8081/users/{{account}}").then((result)=>{
//       console.log(result);
//     })

// }
// }

}
</script>
<style>
</style>