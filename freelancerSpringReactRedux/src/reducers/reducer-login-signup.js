

const initialState = {
    data:'',
    userData:{
        username : '',
        password : '',
        message:'',
        status:'',
        loggedIn : false
    }

};




export default function (state = initialState, action) {


    switch (action.type) {

        case 'LOGIN_SUCCESSFULL':

            return {
                ...state,
                ...state.userData,
                data:action.payload
            };

        case 'SIGNUP_SUCCESSFULL':
            return {
                ...state,
                ...state.userData,
                userData:{
                    message:action.payload.answer,
                    loggedIn:false
                }
            };

        case 'LOGOUT_SUCCESSFULL':
            //localStorage.setItem('loginStatus',action.payload.answer);
            return {
                ...state,
                ...state.userData,
                userData:{
                    message:action.payload.answer,
                    status:action.payload.answer,
                    loggedIn:false
                }
            };
        case 'CHECKLOGIN_SUCCESSFULL':
            return {
                ...state,
                ...state.userData,
                userData:{
                    message:action.payload.answer,
                    loggedIn:false
                }
            };

        default :
            return state;

    }
}