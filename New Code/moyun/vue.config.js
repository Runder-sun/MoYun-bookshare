module.exports = {
    transpileDependencies: ["vuetify"],
    lintOnSave: false,
    devServer: {
        overlay: {
            warning: false,
            errors: false
        },
    },
    publicPath: '/moyun/',
    outputDir: 'dist'
};