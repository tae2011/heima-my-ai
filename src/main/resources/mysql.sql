/*
 Navicat Premium Dump SQL

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : itheima

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 17/08/2025 21:24:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
                           `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校区名称',
                           `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校区所在城市',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '校区表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES (1, '昌平校区', '北京');
INSERT INTO `school` VALUES (2, '顺义校区', '北京');
INSERT INTO `school` VALUES (3, '杭州校区', '杭州');
INSERT INTO `school` VALUES (4, '上海校区', '上海');
INSERT INTO `school` VALUES (5, '南京校区', '南京');
INSERT INTO `school` VALUES (6, '西安校区', '西安');
INSERT INTO `school` VALUES (7, '郑州校区', '郑州');
INSERT INTO `school` VALUES (8, '广东校区', '广东');
INSERT INTO `school` VALUES (9, '深圳校区', '深圳');

SET FOREIGN_KEY_CHECKS = 1;






SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
                           `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学科名称',
                           `edu` int NOT NULL DEFAULT 0 COMMENT '学历背景要求：0-无，1-初中，2-高中、3-大专、4-本科以上',
                           `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '课程类型：编程、设计、自媒体、其它',
                           `price` bigint NOT NULL DEFAULT 0 COMMENT '课程价格',
                           `duration` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '学习时长，单位: 天',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `idx_name`(`name` ASC) USING BTREE COMMENT 'price索引'
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学科表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'JavaEE', 4, '编程', 21999, 108);
INSERT INTO `course` VALUES (2, '鸿蒙应用开发', 3, '编程', 20999, 98);
INSERT INTO `course` VALUES (3, 'AI人工智能', 4, '编程', 24999, 100);
INSERT INTO `course` VALUES (4, 'Python大数据开发', 4, '编程', 23999, 102);
INSERT INTO `course` VALUES (5, '跨境电商', 0, '自媒体', 12999, 68);
INSERT INTO `course` VALUES (6, '新媒体运营', 0, '自媒体', 10999, 61);
INSERT INTO `course` VALUES (7, 'UI设计', 2, '设计', 11999, 66);

SET FOREIGN_KEY_CHECKS = 1;




SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course_reservation
-- ----------------------------
DROP TABLE IF EXISTS `course_reservation`;
CREATE TABLE `course_reservation`  (
                                       `id` int NOT NULL AUTO_INCREMENT,
                                       `course` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '预约课程',
                                       `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名',
                                       `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系方式',
                                       `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预约校区',
                                       `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_reservation
-- ----------------------------
INSERT INTO `course_reservation` VALUES (1, '新媒体运营', '张三丰', '13899762348', '广东校区', '安排一个好点的老师');
INSERT INTO `course_reservation` VALUES (2, 'UI设计', '张三', '120', '昌平校区', '需要试听');
INSERT INTO `course_reservation` VALUES (3, 'AI人工智能', '唐力', '22323', '南京校区', '没有其他备注');
INSERT INTO `course_reservation` VALUES (4, 'AI人工智能', 'Tom张', '1234564897', '南京校区', '不要打电话，加微星详聊');

SET FOREIGN_KEY_CHECKS = 1;
