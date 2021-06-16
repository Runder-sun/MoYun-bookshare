<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
                <div class="card">
                  <div class="front">
                    <v-form ref="form" v-model="valid" lazy-validation>
                      <v-container fluid>
                        <v-col cols="12">
                          <template>
                            <v-container fluid>
                              <v-select v-model="value" :items="items" label="选择推荐目标"
                                :rules="[v => !!v || '推荐目标不能为空']" multiple>
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
                          <v-text-field
                            v-model="title"
                            label="Title"
                            filled
                            shaped
                            height="60px"
                            style="margin-top:40px"
                          ></v-text-field>

                          <v-textarea color="teal" v-model="recommendcontent" :counter="300" required
                            :rules="recommendcontentRules">
                            <template v-slot:label>
                              <div>推荐理由</div>
                            </template>
                          </v-textarea>
                        </v-col>
                        <v-btn class="button" :disabled="!valid" large @click="commitSuccess">
                          <p class="create">发送</p>
                        </v-btn>
                      </v-container>
                    </v-form>
                  </div>
                </div>
              </v-container>
    </div>
</template>


<script>
import bar from "../components/Bar"
  export default {
    data: () => ({
      blogid:'192312',
      title: 'JohnAblog',
      content: 'DoeBcontent',
      snackbar: false,
    }),
    components:{
        bar,
    }
  }
</script>

<style scope>
.EditBlog{
    display:flex;
    align-content: center;}
</style>