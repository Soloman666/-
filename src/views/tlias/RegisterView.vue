<template>
    <div>
<el-form ref='form' :model='form' :rules="rules" label-width="80px" >
  <el-form-item label="账号" prop="account">
    <el-input v-model="form.account"></el-input>
  </el-form-item>

   <el-form-item label="密码" prop="password">
    <el-input  v-model="form.password"></el-input>
  </el-form-item>

   <el-form-item label="年级" prop="grade">
    <el-input  placeholder="请输入年级！" v-model="form.grade"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button @click="onSubmit">提交</el-button>
    <el-button @click="cancel">取消</el-button>
  </el-form-item>
</el-form>

 

    </div>
</template>


<script>
import axios from 'axios'


export default{
     data() {
      return {
         form: {
          account:'',
          password:'',
          grade:'',
         
      },
       rules: {
         account: [
            { required: true, message: '请输入账号名!', trigger: 'blur' },
           
          ],
          password: [
            { required:true, message: '请输入密码！', trigger: 'change' },
           
          ],
         grade: [
            {  trigger: 'blur',validator:(rule,value,callback)=>{
                if(value===''||( !(/^[0-9]{2}$/).test(value))){
                callback(new Error("请输入正确的年级！"))
                }else {
                    callback()
                }
            } },
           
          ],
        
             }
      
     }
     },
     methods:{
        onSubmit(){
             axios.post("http://localhost:8081/register",this.form).then((result) => {
                if(result.data.code===1){
                     alert('注册成功啦！')
                    this.$router.push('/userlogin')
                }
                

      })

        },
          cancel(){
            this.$router.push('/userlogin')
           },
     }
}

</script>

<style>

</style>
