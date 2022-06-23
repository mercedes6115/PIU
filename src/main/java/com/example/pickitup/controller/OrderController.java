
package com.example.pickitup.controller;


import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//
@Controller
@Slf4j
@RequestMapping("/store.do/*")
public class OrderController {

    public void store(UserVO userVO, OrderVO orderVO, ProductVO productVO){
        userVO.getNickname();
        userVO.getPhone();
        userVO.getAddress();
        userVO.getAddressDetail();
        userVO.getPoint();
        productVO.getName();
        productVO.getPrice();
        orderVO.getAddressComment();

    }


}
//public class OrderController {
//
//    public String store(UserVO userVO, OrderVO orderVO,ProductVO productVO){
//        userVO.getNickname();
//        userVO.getPhone();
//        userVO.getAddress();
//        userVO.getAddressDetail();
//        userVO.getPoint();
//        productVO.getName();
//        productVO.getPrice();
//        orderVO.getAddressComment();
//
//        return store(userVO, orderVO, productVO);
//    }
//
//
//}
//public class OrderController {
//
//    @GetMapping("/payment")
//    public String paramTest(UserVO vo, Model model,ProductVO pvo) {
//        String result = "";
//        try {
//            System.out.println("/payment 요청");
//            System.out.println("nickname: " + vo.getNickname());
//            System.out.println("phone: " + vo.getPhone());
//            System.out.println("address: " + vo.getAddress());
//            System.out.println("addressDetail: " + vo.getAddressDetail());
//            System.out.println("name: " + pvo.getName());
//            System.out.println("addressDetail: " + pvo.getPrice());
//
//            model.addAttribute("nickname", vo.getNickname());
//            model.addAttribute("phone", vo.getPhone());
//            model.addAttribute("address", vo.getAddress());
//            model.addAttribute("addressDetail", vo.getAddressDetail());
//            model.addAttribute("name", pvo.getName());
//            model.addAttribute("addressDetail", pvo.getPrice());
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }
//

//    @RequestMapping(value = "/payment", method = RequestMethod.GET)
//    public String userpay(Model model) {
//        UserVO userVO = new UserVO();
//        userVO.get("nickname", userVO.getNickname());
//        userVO.get("address", userVO.getAddress());
//        userVO.get("addressDetail", userVO.getAddressDetail());
//        userVO.get("phone", userVO.getPhone());
//        return "/payment";
//    }
//    @RequestMapping(value = "/payment", method = RequestMethod.GET)
//    public String productpay(Model model) {
//        ProductVO productVO = new ProductVO();
//        model.addAttribute("name", name);
//        productVO.get("name", productVO.getName());
//        productVO.get("address",productVO.getPrice());
//        return "/payment";
//    }
//
//    @RequestMapping(value = "/payment", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, String> add03(@ModelAttribute Book book) {
//        bookService.add(book);
//        Map<String, String> bookDto = new HashMap<>();
//        bookDto.put("title", book.getTitle());
//        bookDto.put("author", book.getAuthor());
//        bookDto.put("comment", book.getComment());
//
//        return bookDto;
//    }

//
//    @GetMapping("/payment")
//    public void payment(){
//
//    }
//
//}
////public class OrderController(Locale locale, Model model, String phone, String nickname, String address, String addressdetail, String name, String price) {
////
////
////    System.out.println(phone);
////
////    PHONE,NICKNAME,ADDRESS,ADDRESSDETAIL,NAME,PRICE
////
////
//////    @GetMapping("/payment")
//////    public void payment(){
//////
//////    }
////
////}