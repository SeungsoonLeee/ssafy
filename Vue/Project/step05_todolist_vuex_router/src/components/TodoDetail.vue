<template>
    <div>
        <table align="center">
            <tr>
                <th>no</th>
                <td>{{getTodoDetail.no}}</td>
            </tr>
            <tr>
                <th>userId</th>
                <td>{{getTodoDetail.userId}}</td>
            </tr>
            <tr>
                <th>content</th>
                <td>{{getTodoDetail.content}}</td>
            </tr>
            <tr>
                <th>writeDate</th>
                <td>{{getTodoDetail.writeDate}}</td>
            </tr>
            <tr>
                <th>endDate</th>
                <td>{{getTodoDetail.endDate}}</td>
            </tr>
            <tr>
                <th>done</th>
                <td>{{getTodoDetail.done}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import Constant from "../Constant";

    export default {
        created () {
            this.$store.dispatch(Constant.GET_TODO, {no:this.$route.params.no});
            console.log(this.$route.params.no); // route.params를 통해 data(no)에 접근할 수 있음
        },
        computed: {
            getTodoDetail() {
                return this.$store.state.todoDetail;
            }
        },
    }
</script>

<style scoped>
table{
    width: 80%;
    font-size: 1.5rem;
}

table th{
    background-color: dimgray;
    color : white;
    border-radius: 5px 0px 0px 5px;
}

table td{
    width: 80%;
    border: solid 1px black;
    border-radius: 0px 5px 5px 0px;
}
</style>