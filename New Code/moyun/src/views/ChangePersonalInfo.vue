<template>
  <div class="ChangePersonalInfo">
    <v-app>
    <bar></bar>
    <v-img src="../assets/widthPic.jpg" width="100%" height="100%">
    <div class="card">
      <div class="front">
        <v-container>
          <v-form ref="form" v-model="valid" lazy-validation>

            <v-card-title>更改个人信息</v-card-title>
        
            <v-container>
              <v-text-field
                v-model="password"
                :rules="passwordRules"
                label="密码"
                required
              ></v-text-field>

              <v-text-field
                v-model="rePassword"
                :rules="rePasswordRules"
                label="确认密码"
                required
              ></v-text-field>

              <v-text-field
                v-model="Email"
                :rules="emailRules"
                label="E-mail"
                required
              ></v-text-field>

              <v-text-field
                v-model="birth"
                :rules="birthRules"
                label="生日"
                required
              ></v-text-field>

              <v-textarea
                color="teal"
                v-model="signature"
                :counter="50"
                required
                :rules="sigRules"
              >
                <template v-slot:label>
                  <div>签名</div>
                </template>
              </v-textarea>

              <v-btn
                :disabled="!valid"
                class="button"
                @click="validate"
                large
                href="/PersonalInfo"
              >
                <p class="login_">保存更改</p>
              </v-btn>
            </v-container>
          </v-form>
        </v-container>
      </div>
    </div>
    </v-img>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
    valid: true,
    password: "",
    passwordRules: [(v) => !!v || "Password is required"],
    rePassword: "",
    rePasswordRules: [
      (v) => !!v || "Password is required",
      (v) => v === this.password || "Not equle",
    ],
    Email: "",
    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
    ],
    birth: "",
    birthRules: [(v) => !!v || "birth is required"],
    checkbox: false,
    signature: "",
	sigRules: [
		v => !!v || '签名内容不能为空',
		v => (v && v.length <= 50) || '书评标题为50个字符以内',
	],
  }),

  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
  },
  components: {
    Bar,
  },
};
</script>

<style>
.login {
  background-color: #efeeee;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
#logo {
  position: relative;
  bottom: -20px;
}

.button {
  color: #596275;
  box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
    -9px -9px 18px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  background-color: #efeeee;
  position: relative;
  top: 30px;
  margin-top: 20px;
  width: 130px;
  height: 55px;
  outline: none;
  border: none;
}
.login_ {
  font-size: 20px;
  margin-top: 15px;
}
.button:hover {
  font-size: 19px;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2),
    -1px -1px 2px rgba(255, 255, 255, 0.8);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  transition: font-size 0.2s ease-out;
}

.card {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  height: 700px;
  width: 550px;
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
.return {
  top: 40px;
}
</style>
