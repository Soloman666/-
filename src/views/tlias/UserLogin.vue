<template>
<div>
 <el-container>
  <el-header>
    <div style="text-align: center">
     <img src="http://bysj.nytdc.edu.cn/bysj_2.0/UploadFiles/1addfb8225554a858a38a28ca4a165de.png" style="text-align: center">

      
    </div>
  </el-header>
  <el-container>
    <el-aside width="600px">
      <el-form ref="form" :model="form" label-width="80px">
        
        
        <img src="https://img.tukuppt.com/png_preview/00/39/33/UQILI8yes6.jpg%21/fw/780" >
  <el-form-item label="账号">
    <el-input v-model="form.account"></el-input>
  </el-form-item>

   <el-form-item label="密码">
    <el-input placeholder="请输入密码" v-model="form.password" show-password></el-input>
  </el-form-item>
 
 
  <el-form-item>
    <el-button type="primary" @click="userLogin">登录</el-button>
    <el-button type="primary" @click="register">注册</el-button>
    <el-button @click="adminLogin">管理员登录</el-button>
  </el-form-item>
</el-form>
    </el-aside>
    <el-main>
      
  <div >
 <el-carousel :interval="5000" arrow="always" height="500px"> 
              <el-carousel-item v-for="img in imgs" :key="img.id">
                <img :src = "img.idView"  alt="">   
                
              </el-carousel-item>
            </el-carousel>


  </div>
    </el-main>
  </el-container>
</el-container>

</div>



</template>


<script>
import axios from 'axios'



export default {
 
el: "#app",
            data() {
                return {
                   form: {
         account: '',
          password: '',
        
        },
                
                    imgs: [
                      
                      
                 {id:0,idView: "https://img2.baidu.com/it/u=1921851264,3319841385&fm=253&fmt=auto&app=138&f=JPEG?w=1153&h=478"},

                 {id:1,idView:"https://img0.baidu.com/it/u=2215372258,3770193385&fm=253&fmt=auto&app=138&f=JPEG?w=690&h=420"},
                      
                 { id:2,idView:"https://img1.baidu.com/it/u=1703481577,3076175820&fm=253&fmt=auto&app=138&f=JPEG?w=760&h=475"},
                      

                   ],
        
                  
                }
            },  

             methods: {
              adminLogin(){
                this.$router.push('/AdminLogin')

              },
      userLogin() {
         axios.post("http://localhost:8081/userlogin",this.form).then((result)=>{

        if(result.data.code === 1){
        this.$router.push('/homeshopping')
         this.$message.success("登陆成功！")
         }else{
          alert("账号或密码错误！")
         }
        })
      
      },
      register(){
         this.$router.push('/RegisterView')

      }
    }
}


  
  
   
    

  

</script>

  <style scoped>
  .el-header {
    background-color: #f2f5f9;
    color: #333;
    text-align: left;
    line-height: 80px;
    
  }
   .el-aside {
    background-color: #f4f6f8;
    color: #6789fa;
    text-align: center;
    line-height: 150px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 180px;
  }



.el-carousel__item img {
    height: 100%;
    width: 100%;
}
</style>



