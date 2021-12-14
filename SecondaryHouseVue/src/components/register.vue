<template>
  <el-form ref="registerForm">
    <el-form-item label="用户">
      <el-input v-model="registerForm.username"></el-input>
    </el-form-item>
    <el-form-item label="密码" >
      <el-input v-model="registerForm.password" show-password></el-input>
    </el-form-item>
    再次输入密码
    <el-input label="重复密码" v-model="passWord2" show-password></el-input>
    <el-form-item label="名字">
      <el-input v-model="registerForm.name"></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-radio v-model="registerForm.sex" label="man">男</el-radio>
      <el-radio v-model="registerForm.sex" label="woman">女</el-radio>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from "axios";

export default {
  name: "register",
  methods: {
    onSubmit() {
      const that = this;
      if (this.registerForm.password!== this.passWord2){
        that.$alert("两次密码不一样！");
        return
      }
      axios.post("http://localhost:8181/register", {
        username: this.registerForm.username,
        password: this.registerForm.password,
        name: this.registerForm.name,
        sex: this.registerForm.sex
      },).then(function (resp) {
        if (resp.data === 'success') {
          that.$alert("注册成功！", '提示', {
            confirmButtonText: "确定",
            callback: () => {
            }
          });
        }
      });
      this.$router.push("/login");
    }
  },
  data() {
    return {
      passWord2:"",
      registerForm: {
        username: "",
        password: "",
        name: "",
        sex: ""
      }
    }
  }
}
</script>

<style scoped>

</style>