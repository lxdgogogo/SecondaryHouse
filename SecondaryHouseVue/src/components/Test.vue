<template>
  <div>
    <input v-model="a"/>
    <input v-model="b"/>
    <div>
      ans: {{sum}}
    </div>
    <div>
      算式：{{str}}
    </div>
  </div>
</template>

<script>
export default {
  name: "Test",
  data() {
    return {
      a: 3,
      b: 5
    }
  },
  computed: {
    sum() {
      return this.a + this.b;
    },
    str() {
      return `${this.a} + ${this.b} = ${this.sum}`;
    }
  }
}
</script>

<style scoped>

</style>