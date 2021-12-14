<template>
  <div>
    <el-button type="info" @click.native.prevent="searchInfo">信息按钮</el-button>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column prop="location"
                       label="房子区域"
                       width="180">
      </el-table-column>
      <el-table-column prop="area"
                       label="房子大小"
                       width="180">
      </el-table-column>
      <el-table-column prop="price"
                       label="房价">
      </el-table-column>
      <el-table-column prop="evaluate"
                       label="评分">
      </el-table-column>
      <el-table-column label="评价"
                       width="120">
        <template slot-scope="scope">
          <el-button
              @click.native.prevent="evaluateDialog=true;evaluateLocation=scope.row.location"
              type="text"
              size="small">
            评价
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="查看具体位置"
                       width="120">
        <template slot-scope="scope">
          <el-button
              @click="lookOver(scope.row.location)"
              type="text"
              size="small">
            查看具体位置
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="删除"
                       width="120">
        <template slot-scope="scope">
          <el-button
              @click.native.prevent="deleteDialog=true;deleteLocation=scope.row.location"
              type="text"
              size="small">
            删除
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="修改"
                       width="120">
        <template slot-scope="scope">
          <el-button
              @click.native.prevent="changeDialog=true;changeForm.location=scope.row.location"
              type="text"
              size="small">
            修改
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button @click.native.prevent="addDialog=true">添加房源</el-button>

    <el-dialog title="评价房源" :visible.sync="evaluateDialog">
      <span class="demonstration">打分</span>
      <el-rate v-model="evaluateMark"></el-rate>
      <el-button @click="evaluateDialog = false">取 消</el-button>
      <el-button type="primary" @click="evaluate">确 定</el-button>
    </el-dialog>

    <el-dialog title="添加房源" :visible.sync="addDialog">
      <el-form ref="addForm">
        <el-form-item label="房子位置">
          <el-input v-model="addForm.location"></el-input>
        </el-form-item>
        <el-form-item label="房子大小">
          <el-input v-model="addForm.area"></el-input>
        </el-form-item>
        <el-form-item label="房价">
          <el-input v-model="addForm.price"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addHouse">添加</el-button>
          <el-button @click="addDialog = false">取 消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog title="确定删除？" :visible.sync="deleteDialog">
      <el-button @click="deleteDialog = false">取 消</el-button>
      <el-button type="primary" @click="deleteHouse">确 定</el-button>
    </el-dialog>

    <el-dialog title="修改房源" :visible.sync="changeDialog">
      <el-form ref="changeForm">
        <el-form-item label="房子大小">
          <el-input v-model="changeForm.area"></el-input>
        </el-form-item>
        <el-form-item label="房价">
          <el-input v-model="changeForm.price"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="changeHouse">修改</el-button>
          <el-button @click="changeDialog = false">取 消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "TablePage",
  //
  data() {
    return {
      tableData: [
        {
          location: '哈尔滨市南岗区',
          area: '80',
          price: '100w',
          evaluate: 5
        }, {
          location: '哈尔滨市香坊区',
          area: '80',
          price: '90w',
          evaluate: 10
        }],
      evaluateDialog: false,
      addDialog: false,
      deleteDialog: false,
      deleteLocation: "",
      evaluateLocation: "",
      lookLocation: "",
      changeDialog: false,
      evaluateMark: 0,
      addForm: {
        location: "",
        area: "",
        price: ""
      },
      changeForm: {
        location: "",
        area: "",
        price: ""
      }
    }
  },
  methods: {
    created() {
      console.log(this.$store.state.token)
    },
    evaluate() {
      const that = this;
      this.evaluateDialog = false;
      console.log(this.evaluateMark)
      axios.post("http://localhost:8181/evaluateHouse", {
        location: this.evaluateLocation,
        evaluate: this.evaluateMark
      }).then(function (resp) {
        if (resp.data === 'success') {
          that.$alert("评价成功！", '提示');
        }
      });
      this.getData()
    },
    addHouse() {
      const that = this;
      axios.post("http://localhost:8181/addHouse", this.addForm).then(function (resp) {
        that.addDialog = false;
        that.getData();
        if (resp.data === 'success') {
          that.$alert("添加成功！", '提示');
        }

      });
    },
    deleteHouse() {
      const that = this;
      axios.post("http://localhost:8181/deleteHouse",
          {location: this.deleteLocation}
      ).then(function (resp) {
        if (resp.data === 'success') {
          that.$alert("删除成功！", '提示');
        }
      });
      this.deleteDialog = false;
      this.getData()
    },
    changeHouse() {
      this.changeDialog = false;
      const that = this;
      axios.post("http://localhost:8181/changeHouse", this.changeForm).then(function (resp) {
        if (resp.data === 'success') {
          that.$alert("修改成功！", '提示');
        }
      })
      this.getData()
    },
    getData() {
      const that = this;
      axios.get("http://localhost:8181/house").then(function (resp) {
        console.log(resp);
        that.tableData = resp.data;
      })
    },
    searchInfo() {
      this.$router.push("/userInfo");
    },
    lookOver(lookLocation) {
      this.lookLocation = lookLocation;
      console.log(1)
      console.log(this.lookLocation);
      this.$router.push({
        path: "map",
        query: {
          loc: this.lookLocation
        }
      });
    }
  },
  created() {
    this.getData()
  }
}
</script>

<style scoped>
</style>