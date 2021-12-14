<template>
  <el-form ref="form">
    <el-form-item label="用户">
      <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input type="password" v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">登录</el-button>
      <el-button @click="register">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  username: "",
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    }
  },
  methods: {
    onSubmit() {
      const that = this;
      axios.post("http://localhost:8181/login", this.form).then(function (resp){
        if (resp.data.code === 200){
          console.log(resp)
          let data=resp.data.data;
          let token=data.token;
          let user=data.user;
          that.$store.commit('SET_TOKEN', token)
          //存储user，优雅一点的做法是token和user分开获取
          that.$store.commit('SET_USER', user);
          console.log(that.$store.state.token);
          that.$alert("登录成功！", '提示',{
            confirmButtonText: "确定"
          });
          that.$router.push("/table")
        }
        else{
          that.$alert("密码错误")
        }
      });
    },
    register(){
      this.$router.push("/register");
    }
  }
}
</script>

<style scoped>

</style>