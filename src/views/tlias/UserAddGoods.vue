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

    <el-form ref="form" :model="form" :rules="rules" label-width="100px">
     

      <el-form-item label="商品名称" prop="goodname">
        <el-input
          placeholder="请输入商品名称！"
          v-model="form.goodname"
        ></el-input>
      </el-form-item>

      

      <el-form-item label="商品价格" prop="prize">
        <el-input
          placeholder="请输入商品价格！"
          v-model="form.prize"
        ></el-input>
      </el-form-item>

      <el-form-item label="交易地点" prop="place">
        <el-input
          placeholder="请输入交易地点！"
          v-model="form.place"
        ></el-input>
      </el-form-item>

       <el-form-item label="商品成色" prop="fineness">
        <el-input
          placeholder="请输入商品成色！"
          v-model="form.fineness"
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button @click="onSubmit('form')">提交</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
</div>
    
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      optType: "", //当前操作的类型
      fits: ["fill"],
      url: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fss2.meipian.me%2Fusers%2F148864215%2F7c98b57009d0f373bbb59531b40f49d7.jpg%3Fmeipian-raw%2Fbucket%2Fivwen%2Fkey%2FdXNlcnMvMTQ4ODY0MjE1LzdjOThiNTcwMDlkMGYzNzNiYmI1OTUzMWI0MGY0OWQ3LmpwZw%3D%3D%2Fsign%2F4c40d81abb279ab7b5f06cd6b74a3ec7.jpg&refer=http%3A%2F%2Fss2.meipian.me&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1716716831&t=4c4ca5a6b25cc9647c8fd6908787854b",
      form: {
       
        goodname: "",
        prize: null,
        place: "",
        fineness:""
      },
      rules: {
       
        goodname: [
          { required: true, message: "请输入商品名称！", trigger: "change" },
        ],
        prize: [
          {
            trigger: "blur",
            validator: (rule, value, callback) => {
              if (value === "" || !/^[0-9]+$/.test(value)) {
                callback(new Error("请输入商品价格！"));
              } else {
                callback();
              }
            },
          },
        ],
        place: [
          { required: true, message: "请输入交易地点！", trigger: "blur" },
        ],
         fineness
         : [
          { required: true, message: "请输入商品成色！", trigger: "change" },
        ],
      },
    };
  },
  methods:{
    cancel() {
      this.$router.push("/homesellinggoods");
    },

    onSubmit(){
        axios.post("http://localhost:8081/addmygoods",this.form).then((result) => {
              if (result.data.code === 1) {
                alert("添加成功！")
                this.$router.push("/homesellinggoods");
              }
            });

    }
  }
}

</script>

<style>

</style>
