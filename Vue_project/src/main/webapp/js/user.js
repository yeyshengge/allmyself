new Vue({
    el: "#app",
    data: {
        user: {},
        userList: []
    },
    methods: {
        findAll: function () {
            var _this = this;
            axios.get("/user/findAll.do").then(function (response) {
                _this.userList = response.data;
            })
        },
        findById: function (userId) {
            var _this = this;
            axios.get("/user/findById.do", {
                params: {
                    id: 1
                }
            }).then(function (response) {
                _this.user = response.data;
            })
        },
        update: function (user) {
            var _this = this;
            axios.post("/user/updateUser.do", _this.user).then(function (response) {
                _this.findAll();
            })
        }
    },
    created: function () {
        this.findAll();
    }
});


/*
new Vue({
    el: "#app",
    data: {
        user: {
            id: "1",
        },
        userList: []
    },
    methods: {
        findAll: function () {
            var _this = this;
            axios.get('/user/findAll.do')
                .then(function (response) {
                    //获取数据
                    _this.userList = response.data;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        findById: function (userid) {
            var _this = this;
            axios.get("/user/findById.do", {
                params: {
                    id: userid
                }
            }).then(function (response) {
                _this.user = response.data;//获取数据
                $('#myModal').modal("show");//使模态窗口显示
            }).catch(function (err) {
            });

        },
        update: function (user) {
            var _this = this;
            axios.post("/user/updateUser.do", _this.user).then(function (response) {
                _this.findAll();
            }).catch(function (err) {
            });
        }
    },
    created: function () {
        this.findAll();
    }
});*/
