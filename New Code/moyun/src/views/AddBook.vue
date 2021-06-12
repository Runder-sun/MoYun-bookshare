<template>
	<div class="AddBook">
		<v-app>
			<bar></bar>
			<v-container>
				<el-form ref="form" :rules="rules" :model="form" label-width="380px">
					<v-cintainer>
						<el-form-item label="图书名称" prop="bookname">
							<el-input v-model="form.bookname" placeholder="请输入图书名称" clearable></el-input>
						</el-form-item>
						<el-form-item label="图书分类" prop="items">
							<v-col cols="12" sm="6">
								<v-select v-model="form.items" :items="items" attach chips label="选择图书类别" multiple>
								</v-select>
							</v-col>
						</el-form-item>
						<el-form-item label="作者" prop="author">
							<el-input v-model="form.author" placeholder="请输入作者" clearable></el-input>
						</el-form-item>
						<el-form-item label="ISBN号" prop="ISBN">
							<el-input v-model="form.ISBN" placeholder="请输入ISBN号" clearable></el-input>
						</el-form-item>
						<el-form-item label="出版社" prop="cbs">
							<el-input v-model="form.cbs" placeholder="请输入出版社" clearable></el-input>
						</el-form-item>
						<el-form-item label="简介" prop="desc">
							<el-input type="textarea" v-model="form.desc" placeholder="请输入简介" clearable></el-input>
						</el-form-item>
						<el-form-item label="上传封面" prop="filebookcover">
							<el-upload class="upload-demo" ref="upload"
								action="https://jsonplaceholder.typicode.com/posts/" :on-preview="handlePreview"
								:on-remove="handleRemove" :file-list="filebookcover" :auto-upload="false">
								<el-button slot="trigger" size="small" type="primary">选取文件</el-button>
								<el-button style="margin-left: 10px" size="small" type="success" @click="submitUpload">
									上传到服务器</el-button>
								<div slot="tip" class="el-upload__tip">
									只能上传jpg/png文件，且不超过500kb
								</div>
							</el-upload>
						</el-form-item>
						<el-form-item label="上传电子书" prop="fileebook">
							<el-upload class="upload-demo" ref="upload"
								action="https://jsonplaceholder.typicode.com/posts/" :on-preview="handlePreview"
								:on-remove="handleRemove" :file-list="fileebook" :auto-upload="false">
								<el-button slot="trigger" size="small" type="primary">选取文件</el-button>
								<el-button style="margin-left: 10px" size="small" type="success" @click="submitUpload">
									上传到服务器</el-button>
								<div slot="tip" class="el-upload__tip">
									只能上传pdf文件，且不超过500kb
								</div>
							</el-upload>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" @click="onSubmit('form')">添加</el-button>
							<el-button type="primary" @click="onSubmitAndCheck('form')">添加并查看新书</el-button>
						</el-form-item>
					</v-cintainer>
				</el-form>
			</v-container>
		</v-app>
	</div>
</template>

<script>
	import Bar from "../components/Bar.vue";
	export default {
		data: () => ({
			items: [
				"文学",
				"科幻",
				"侦探",
				"纪实",
				"儿童",
				"艺术",
				"历史",
				"武侠",
				"地理",
				"医药健康",
				"IT",
				"数学",
			],
			value: [],
			form: {
				bookname: "",
				author: "",
				ISBN: "",
				cbs: "",
				desc: "",
				delivery: false,
				items: [],
				resource: "",
				filebookcover: [{
						name: "",
						url: "",
					},
					{
						name: "",
						url: "",
					},
				],
				fileebook: [{
						name: "",
						url: "",
					},
					{
						name: "",
						url: "",
					},
				],
			},
			rules: {
				bookname: [{
						required: true,
						message: '请输入图书名称',
						trigger: 'blur'
					},
					{
						min: 2,
						max: 30,
						message: '长度在 2 到 30 个字符',
						trigger: 'blur'
					},
				],
				items: [{
					required: true,
					message: '请选择图书分类',
					trigger: 'blur'
				}],
				author: [{
						required: true,
						message: '请输入作者',
						trigger: 'blur'
					},
					{
						min: 2,
						max: 30,
						message: '长度在 2 到 30 个字符',
						trigger: 'blur'
					},
				],
				ISBN: [{
						required: true,
						message: '请输入ISBN号',
						trigger: 'blur'
					},
					{
						min: 2,
						max: 50,
						message: '长度在 2 到 30 个字符',
						trigger: 'blur'
					},
				],
				cbs: [{
						required: true,
						message: '请输入出版社',
						trigger: 'blur'
					},
					{
						min: 2,
						max: 100,
						message: '长度在 2 到 30 个字符',
						trigger: 'blur'
					},
				],
				desc: [{
						required: true,
						message: '请输入简介',
						trigger: 'blur'
					},
					{
						min: 2,
						max: 3000,
						message: '长度在 2 到 30 个字符',
						trigger: 'blur'
					},
				],
				filebookcover: [{
					required: true,
					message: '请上传封面',
					trigger: 'change'
				}],
				fileebook: [{
					required: true,
					message: '请上传电子书',
					trigger: 'change'
				}],
			}
		}),

		methods: {
			onSubmit(ruleForm) {
				this.$refs[ruleForm].validate(valid => {
					if (valid) {
						console.log("success submit");
						alert("添加成功");
					} else {
						console.log("error submit");
						return false;
					}
				});
			},
			onSubmitAndCheck(ruleForm) {
				//alert("添加成功");
				this.$refs[ruleForm].validate(valid => {
					if (valid) {
						this.$router.push({
							path: "/Book/CheckBook"
						});
						console.log("success submit");
					} else {
						console.log("error submit");
						return false;
					}
				});
				
			},
			submitUpload() {
				 this.$refs.upload.submit();
			}, 

			handleRemove(file, fileList) {
				console.log(file, fileList);
			},
			handlePreview(file) {
				console.log(file);
			},
		},
		components: {
			Bar,
		},
	};
</script>
