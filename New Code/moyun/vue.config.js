module.exports = {
    transpileDependencies: ["vuetify"],
    lintOnSave: false,
    devServer: {
        overlay: {
            warning: false,
            errors: false
        },
        proxy: {
            '/api': {
                target: 'http://39.105.38.175:8080/', //别忘记加协议！！如http://
                secure: false, // 如果是 https ,需要开启这个选项
                changeOrigin: true, //开启跨域
                pathRewrite: {
                    '^/api': '/' //正则匹配，相当于用api替换target中的地址
                }
            }
        }
    },
    publicPath: './',
    outputDir: 'dist'
};