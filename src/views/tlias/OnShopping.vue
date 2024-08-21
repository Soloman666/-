<template>
<div>
<el-form ref="form" :model="form" label-width="80px">
  <el-form-item label="卖家id" prop="sellerid">
    <el-input v-model="form.sellerid" :readonly="true"></el-input>
  </el-form-item>
<el-form-item label="卖家" prop="selleraccount">
    <el-input v-model="form.selleraccount" :readonly="true"></el-input>
  </el-form-item>
  <el-form-item label="商品名称" prop="goodname">
    <el-input v-model="form.goodname" :readonly="true"></el-input>
  </el-form-item>
  <el-form-item label="商品价格" prop="prize">
    <el-input v-model="form.prize" :readonly="true"></el-input>
  </el-form-item>
  <el-form-item label="交易地点" prop="place">
    <el-input v-model="form.place" :readonly="true"></el-input>
  </el-form-item>
  <el-form-item label="成色" prop="fineness">
    <el-input v-model="form.fineness" :readonly="true"></el-input>
  </el-form-item>
   <el-form-item>
    <el-button  @click="onBuy">确认购买</el-button>
    <el-button @click="cancel">取消</el-button>
  </el-form-item>
</el-form>
</div>
</template>


<script>
import axios from 'axios';
 export default {
    data() {
      return {
        form:{
            sellerid:'',
            selleraccount:'',
            goodname:'',
            prize:'',
            place:'',
            fineness:'',
        }
      }
    },
     
     methods:{
     cancel(){
            this.$router.push('/homeshopping')
           },
     onBuy(){
          axios.put("http://localhost:8081/shopping1",this.form).then((result)=>{
          if (result.data.code===1){
            axios.post("http://localhost:8081/insertorder").then(()=>{
                
            })
           this.$message.success("购买成功！")
            this.$router.push('/homeshopping')
          }

        })


     }
     },

    created() {
         axios.get("http://localhost:8081/searchgoods/"+this.$route.query.number).then((result=>{
              this.form = result.data.data
         }))
    },
 }

</script>

<style>

</style>
