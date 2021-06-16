<template>
	<div class="Reading">
		<v-app>
			<bar></bar>
			<v-container>
				<br>
				<el-button @click="onCheckBook('1234')">返回</el-button>
            </v-container>
			<v-container>
				<template>
					后期调整为PDF在线阅览
					后期调整为PDF在线阅览后期调整为PDF在线阅览
					
					<div style="height:500px;width:100%;overflow:scroll;background:#EEEEEE;">
						<div class="post_body">
							 
							<div class="video-wrapper" style="margin: 10px auto;background: #F5F5F5;">
								<div class="video-inner" style="padding: 25px;padding-bottom:20px;">
									 <div class="video-info clearfix"
										style="margin: 16px 0 0px 0px;height:20px;line-height:20px;">
										<p class="fn-right"
											style="height: 22px;line-height: 22px;overflow: hidden;font-size:12px;float: right; margin:0;padding:0;text-indent:0;">
											<a style="text-align: right;float: left;width: 300px;"
												href="http://v.163.com/static/3/VK9OUEG5H.html" target="_blank"
												class="video-title">学习正当时丨家是玉麦 国是中国</a>
											<span class="video-from"
												style="color: #a7a7a7;margin-left:10px">（来源：央广网）</span>
										</p>
									</div>
									<div class="video-list">
										<ul class="clearfix" style="margin:0;padding:0;list-style:none;width:540px;">
										</ul>
									</div>
								</div>
								 </div>
							<!--结束-->
							<p></p>
							<p>1997年以前，西藏<a target="_blank"
									href="https://news.163.com/news/search?keyword=%E7%8E%89%E9%BA%A6">玉麦</a>乡仅有<a
									target="_blank"
									href="https://news.163.com/news/search?keyword=%E6%A1%91%E6%9D%B0">桑杰</a><a
									target="_blank"
									href="https://news.163.com/news/search?keyword=%E6%9B%B2%E5%B7%B4">曲巴</a>和两个女儿卓嘎、央宗一户人家居住，外界称作“三人乡”。桑杰曲巴一家人在极为艰苦的条件下，日夜守护着祖国的边疆，一守就是近半个世纪。
							</p>
							<p>
								<!--StartFragment-->
							</p>
							<p>2017年10月，习近平总书记给卓嘎和央宗回信，希望她们继续传承爱国守边的精神，带动更多牧民群众像格桑花一样扎根在雪域边陲，做神圣国土的守护者、幸福家园的建设者。</p>
							<p>如今，在乡政府旁，桑杰曲巴故居已基本完成布展，恢复“三人乡”时的生活场景，作为爱国主义教育基地，致敬桑杰曲巴一家的固边守边精神。</p>
							<p>在玉麦，户户高挂五星红旗，人人都是国家的坐标。从1户3人到如今的67户234人，2020年，玉麦乡农牧民人均可支配收入达34012元，边境小康村的建设让乡里的面貌焕然一新。
							</p>
							<p>今天，玉麦儿女继续传唱着“家是玉麦 国是中国”。</p>
							<p>
								<!--EndFragment-->
							</p>
							<div style="height: 0px;overflow:hidden;"><img
									src="https://static.ws.126.net/163/f2e/product/post_nodejs/static/logo.png"></div>
						</div>
					</div>
				</template>
			</v-container>
		</v-app>
	</div>
</template>

<script>
	import Bar from "../components/Bar.vue";
	export default {
		data: () => ({
			textarea: '',
		}),

		methods: {
onCheckBook(bookid) {
				this.$router.push('/Book/CheckBook?BookID=' + bookid);
			},
		},
		components: {
			Bar,
		},
	};
</script>
