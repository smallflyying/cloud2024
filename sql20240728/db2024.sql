/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL8.0
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3307
 Source Schema         : db2024

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 28/07/2024 14:46:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pay_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '支付流水号',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单流水号',
  `user_id` int(10) NULL DEFAULT 1 COMMENT '用户账号ID',
  `amount` decimal(8, 2) NOT NULL DEFAULT 9.90 COMMENT '交易金额',
  `deleted` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '支付交易表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pay
-- ----------------------------
INSERT INTO `t_pay` VALUES (1, 'paycbb001', 'order001', 3, 219.90, 0, '2024-07-13 00:08:28', '2024-07-13 14:03:00');
INSERT INTO `t_pay` VALUES (4, 'payrest001', 'orderest001', 2, 3.33, 0, '2024-07-14 16:55:45', '2024-07-14 16:55:45');
INSERT INTO `t_pay` VALUES (6, 'payrest006', 'orderest006', 2, 9.15, 0, '2024-07-14 16:26:53', '2024-07-14 17:01:20');
INSERT INTO `t_pay` VALUES (7, 'payrest007', 'orderest007', 7, 19.15, 0, '2024-07-14 17:00:05', '2024-07-14 17:02:30');
INSERT INTO `t_pay` VALUES (8, 'payrest002', 'orderest002', 2, 2.33, 0, '2024-07-14 17:14:05', '2024-07-14 17:14:05');
INSERT INTO `t_pay` VALUES (9, 'payfeign88888', 'consumer-feign3', 2, 8.28, 0, '2024-07-18 23:16:31', '2024-07-18 23:16:31');

SET FOREIGN_KEY_CHECKS = 1;
