<template>
  <div class="BookRecommand">
    <v-app>
        <div class="background">
            <img src="https://cdn.vuetifyjs.com/images/parallax/material.jpg"  width="100%" height="100%" alt="" />
        </div>
      <bar></bar>
      <v-container>
        <div class="card">
          <div class="front">
            <v-form>
              <v-container fluid>
                <v-col cols="12">
                  <template>
                    <v-container fluid>
                       <v-select
                         v-model="value"
                         :items="items"
                         label="选择推荐目标"
                         multiple
                       >
                          <template v-slot:selection="{ item, index }">
                             <v-chip v-if="index === 0">
                                 <span>{{ item }}</span>
                             </v-chip>
                             <span v-if="index === 1" class="grey--text caption">
                                 (+{{ value.length - 1 }} others)
                             </span>
                         </template>
                       </v-select>
                     </v-container>
                  </template>

                  <v-textarea color="teal">
                    <template v-slot:label>
                      <div>推荐理由</div>
                    </template>
                  </v-textarea>
                </v-col>
                <v-btn class="button" large>
                  <p class="create">发送</p>
                </v-btn>
              </v-container>
            </v-form>
          </div>
        </div>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  setup() {},
  components: {
    Bar,
  },
  data: () => ({
      items: ['龙', '赵', '叶', '沈', '罗', '陈'],
      value: [],
    }),
};
</script>

<style scoped>

.card {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  height: 500px;
  width: 600px;
  z-index: 1;
  transition: transform 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}
.card .front {
  position: absolute;
  text-align: center;
  box-shadow: 12px 12px 24px rgba(0, 0, 0, 0.1),
    -12px -12px 24px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  background-color: #efeeee;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  transition: 1s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}
.card .front {
  z-index: 1;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.button {
  color: #596275;
  box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
    -9px -9px 18px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  background-color: #efeeee;
  position: relative;
  top: 0px;
  margin-top: 20px;
  width: 130px;
  height: 55px;
  outline: none;
  border: none;
}
.button:hover {
  font-size: 19px;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2),
    -1px -1px 2px rgba(255, 255, 255, 0.8);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  transition: font-size 0.2s ease-out;
}

</style>