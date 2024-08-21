<template>
  <div>
    <div class="demo-image">
      <div class="block" v-for="fit in fits" :key="fit">
        <el-image
          style="width: 750px; height: 500px"
          :src="url"
          :fit="fit"
        ></el-image>
      </div>
    </div>

    <el-form ref="form" :model="form" :rules="rules" label-width="100px">
      <el-form-item label="卖家id" prop="sellerid">
        <el-input
          placeholder="请输入卖家id！"
          v-model="form.sellerid"
        ></el-input>
      </el-form-item>

      <el-form-item label="卖家账号" prop="selleraccount">
        <el-input
          placeholder="请输入卖家账号！"
          v-model="form.selleraccount"
        ></el-input>
      </el-form-item>

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
      url: "https://img1.baidu.com/it/u=601909300,1675472908&fm=253&fmt=auto&app=138&f=JPEG?w=533&h=300",
      form: {
        sellerid:null,
        selleraccount: "",
        goodname: "",
        prize: null,
        place: "",
        fineness:""
      },
      rules: {
        sellerid: [
          { 
            trigger: "blur",
            validator: (rule, value, callback) => {
              if (value===''||( !(/^[0-9]*$/).test(value))){
                callback(new Error("请输入正确的卖家id！"));
              } else {
                callback();
              }
            },
          },
        ],
        selleraccount: [
          { required: true, message: "请输入卖家账号！", trigger: "change" },
        ],
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

  

  methods: {
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("提交成功啦！");
          axios
            .post("http://localhost:8081/addgoods", this.form)
            .then((result) => {
              if (result.data.code === 1) {
                this.$router.push("/goods");
              }
            });
        }
      });
    },
    cancel() {
      this.$router.push("/goods");
    },
  },
};
</script>

<style>
</style>