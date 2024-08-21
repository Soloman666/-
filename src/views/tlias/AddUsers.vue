<template>
    <div>
<div class="demo-image">
  <div class="block" v-for="fit in fits" :key="fit">
   
    <el-image
      style="width: 500px; height: 450px"
      :src="url"
      :fit="fit"></el-image>
  </div>
</div>

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

   <el-form-item label="余额" prop="balance">
    <el-input v-model="form.balance"></el-input>
  </el-form-item>



  <el-form-item>
    <el-button  @click="onSubmit('form')">提交</el-button>
    <el-button @click="cancel">取消</el-button>
  </el-form-item>
</el-form>
</div>
</template>


<script>
import axios from 'axios'

  export default {
    data() {
      return {
        optType:"",//当前操作的类型
         fits: ['fill'],
        url: 'https://img1.baidu.com/it/u=1159995757,2491210286&fm=253&fmt=auto&app=138&f=JPEG?w=280&h=280',
        form: {
          account:'',
          password:'88888888',
          grade:'',
          balance:'',
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
          balance: [
            { required: true, message: '请输入余额！（没钱写0）', trigger: 'blur' },
            
          ],
             }
        }
    },


    created(){
    
         this.optType= this.$route.query.id ? 'update' :'add'  
         if(this.optType==='update'){
         axios.get("http://localhost:8081/addusers/"+this.$route.query.id).then((result=>{
              this.form = result.data.data
         })
         )
         }
            },


    methods: {
      onSubmit(formName) {
       this.$refs[formName].validate((valid) =>{
        if(valid){
          if(this.optType==='add'){
            // 新增操作
            alert('提交成功啦！')
            axios.post("http://localhost:8081/addusers",this.form).then((result) => {
                if(result.data.code===1){
                    this.$router.push('/users')
                }
                

      })}else{
        // 修改操作
        axios.put("http://localhost:8081/addusers",this.form).then((result)=>{
          if (result.data.code===1){
           this.$message.success("信息修改成功！")
            this.$router.push('/users')
          }

        })
      }
        }
       })
      },
           cancel(){
            this.$router.push('/users')
           },
    }
  }
</script>

<style>

</style>