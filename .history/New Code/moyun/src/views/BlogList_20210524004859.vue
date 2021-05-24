<template>
    <div class="BlogList">
    <v-app>
        <bar></bar>
        <v-container>
        <v-toolbar flat style="margin-top:30px">
        <v-toolbar-title>个人日志列表</v-toolbar-title>

        <v-spacer></v-spacer>
        
        <template>
          <v-btn
            color="blue darken-3"
            text
            @click.stop="dialog = true"
          >
            发表日志
          </v-btn>

          <v-dialog
            v-model="dialog"
            width="1000px"
            height="1800px"
          >
            <v-card flat>
                <v-snackbar
                  v-model="snackbar"
                  absolute
                  top
                  right
                  color="success"
                >
                  <span>Registration successful!</span>
                  <v-icon dark>mdi-checkbox-marked-circle</v-icon>
                </v-snackbar>
                <v-form ref="form" @submit.prevent="submit">
                  <v-container fluid>
                    <v-row>
                      <v-col cols="12" sm="6">
                        <v-text-field
                          v-model="form.first"
                          :rules="rules.name"
                          color="purple darken-2"
                          label="First name"
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6">
                        <v-text-field
                          v-model="form.last"
                          :rules="rules.name"
                          color="blue darken-2"
                          label="Last name"
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12">
                        <v-textarea
                          v-model="form.bio"
                          color="teal"
                        >
                          <template v-slot:label>
                            <div>
                              Bio <small>(optional)</small>
                            </div>
                          </template>
                        </v-textarea>
                      </v-col>
                      <v-col cols="12" sm="6">
                        <v-select
                          v-model="form.favoriteAnimal"
                          :items="animals"
                          :rules="rules.animal"
                          color="pink"
                          label="Favorite animal"
                          required
                        ></v-select>
                      </v-col>
                      <v-col cols="12" sm="6">
                        <v-slider
                          v-model="form.age"
                          :rules="rules.age"
                          color="orange"
                          label="Age"
                          hint="Be honest"
                          min="1"
                          max="100"
                          thumb-label
                        ></v-slider>
                      </v-col>
                      <v-col cols="12">
                        <v-checkbox
                          v-model="form.terms"
                          color="green"
                        >
                          <template v-slot:label>
                            <div @click.stop="">
                              Do you accept the
                              <a href="javascript:;" @click.stop="terms = true">terms</a>
                              and
                              <a href="javascript:;" @click.stop="conditions = true">conditions?</a>
                            </div>
                          </template>
                        </v-checkbox>
                      </v-col>
                    </v-row>
                  </v-container>
                  <v-card-actions>
                    <v-btn text @click="resetForm">Cancel</v-btn>
                    <v-spacer></v-spacer>
                    <v-btn
                      :disabled="!formIsValid"
                      text
                      color="primary"
                      type="submit"
                    >Register</v-btn>
                  </v-card-actions>
                </v-form>
                <v-dialog v-model="terms" width="70%">
                  <v-card>
                    <v-card-title class="title">Terms</v-card-title>
                    <v-card-text v-for="n in 5" :key="n">
                      {{ content }}
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn
                        text
                        color="purple"
                        @click="terms = false"
                      >Ok</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
                <v-dialog v-model="conditions" width="70%">
                  <v-card>
                    <v-card-title class="title">Conditions</v-card-title>
                    <v-card-text v-for="n in 5" :key="n">
                      {{ content }}
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn
                        text
                        color="purple"
                        @click="conditions = false"
                      >Ok</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-card>
          </v-dialog>
         
        </template>


        <v-btn text color="teal" href="/BlogList/PersonalCollection" rounded> 查看日志收藏 </v-btn>
        </v-toolbar>
        <template>
        <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            :default-sort = "{prop: 'name', order: 'descending'}">
            <el-table-column
            fixed
            sortable
            prop="name"
            label="日志名称"
            style="width: 35%">
            </el-table-column>
            <el-table-column 
            sortable           
            prop="date"
            label="日期"
            style="width: 30%">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            style="width: 35%">
            <template slot-scope="scope">
                <v-btn text color="cyan lighten-1" href="/BlogList/ScanBlog" rounded @click="handleEdit(scope.$index, scope.row)"> 查看 </v-btn>
                <v-btn text color="blue darken-1" href="/BlogList/EditBlog" rounded @click="handleEdit(scope.$index, scope.row)"> 编辑 </v-btn>
                <v-btn text color="pink lighten-1" rounded @click="handleDelete(scope.$index, scope.row)"> 删除 </v-btn>
            </template>
            </el-table-column>
        </el-table>
        </template> 
        </v-container>
    </v-app>
    </div>
</template>

<script>
import bar from "../components/Bar.vue"

export default({
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
    data() {
      return {
        dialog: false,
        rules: [
          value => !!value || 'Required.',
          value => (value && value.length >= 3) || 'Min 3 characters',
        ],
        tableData: [{
          name: "在墨韵的第一天",
          date: "2021/5/21",
        },
        {
          name: "在墨韵的第二天",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第三天",
          date: "2021/5/23",
        },
        {
          name: "在墨韵的第三天2",
          date: "2021/4/22",
        },
        {
          name: "在墨韵的第三天3",
          date: "2021/5/12",
        },
        {
          name: "在墨韵的第四天",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第四天1",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第四天2",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第四天3",
          date: "2021/5/22",
        },        
        ]
      }
    },
    components:{
    bar,
},
})
</script>

<style scoped>
.BlogList{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};

</style>
