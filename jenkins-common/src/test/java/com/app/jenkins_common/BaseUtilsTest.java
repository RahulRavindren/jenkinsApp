package com.app.jenkins_common;


import com.app.jenkins_common.utils.BaseUtils;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4ClassRunner.class)
public class BaseUtilsTest {

  @Test
  public void isEmptyStringTest() {
    final String str = "";
    Assert.assertTrue(BaseUtils.getInstance().isEmpty(str));
  }

  @Test
  public void isEmptyStringTestNullString() {
    final String str = null;
    Assert.assertTrue(BaseUtils.getInstance().isEmpty(str));
  }

  @Test
  public void isEmptyCollectionTest() {
    final Collection collection = new ArrayList();
    Assert.assertTrue(BaseUtils.getInstance().isEmpty(collection));
  }

  @Test
  public void isEmptyCollectionTestNullCollection() {
    final Collection collection = null;
    Assert.assertTrue(BaseUtils.getInstance().isEmpty(collection));
  }

  @Test
  public void isEmptyObjectTest() {
    final String[] str_array = new String[]{};
    Assert.assertTrue(BaseUtils.getInstance().isEmpty(str_array));
  }

  @Test
  public void isEmptyObjectNull() {
    final String[] str_array = null;
    Assert.assertTrue(BaseUtils.getInstance().isEmpty(str_array));
  }

  @Test
  public void copyAllTest() {
    final Map<String, String> sourceMap = new HashMap<>();
    sourceMap.put("test", "test");
    final Map<String, String> destinationMap = new HashMap<>();
    Assert.assertEquals(sourceMap, BaseUtils.getInstance().copyAll(destinationMap, sourceMap));
  }

  @Test
  public void copyAllTestSourceNull() {
    final Map<String, String> destination = new HashMap<>();
    Assert.assertEquals(destination, BaseUtils.getInstance().copyAll(destination, null));

  }

  @Test
  public void copyAllTestDestinationNull() {
    final Map<String, String> source = new HashMap<>();
    source.put("test", "test");
    Assert.assertEquals(source, BaseUtils.getInstance().copyAll(null, source));
  }

  @Test
  public void isValidIntegerTest() {
    final String integer = "1";
    Assert.assertTrue(BaseUtils.getInstance().isValidInteger(integer));
  }

  @Test
  public void isValidIntegerTest1() {
    final String integer = "a";
    Assert.assertFalse(BaseUtils.getInstance().isValidInteger(integer));
  }

  @Test
  public void equalsListBothEmptyList() {
    final List<String> list1 = new ArrayList<>();
    final List<String> list2 = new ArrayList<>();
    Assert.assertFalse(BaseUtils.getInstance().equalsList(list1, list2));
  }

  @Test
  public void equalsListUnequal() {
    List<String> list1 = new ArrayList<>(3);
    Collections.fill(list1, "a");
    List<String> list2 = new ArrayList<>(4);
    Collections.fill(list2, "b");
    Assert.assertFalse(BaseUtils.getInstance().equalsList(list1, list2));
  }


}
