package com.zlt.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//该类通过传入一个章节的列表（通过章节id获得）来实例化，通过buildTree方法对章节进行排好序并返回排序后的列表
public class TreeService
{
    private List<Chapter> chapters = new ArrayList<Chapter>();

    public TreeService(List<Chapter> chaptersList)
    {
        this.chapters = chaptersList;
    }

    // 建立树形结构
    public List<Chapter> buildTree()
    {
        List<Chapter> treeChapter = new ArrayList<Chapter>();
        for (Chapter chapterNode : getRootNode())
        {
            chapterNode = buildChilTree(chapterNode);
            treeChapter.add(chapterNode);
        }
        return treeChapter;
    }

    // 递归，建立子树形结构
    private Chapter buildChilTree(Chapter pNode)
    {
        Map<String, Chapter> chaptermap = new HashMap<String, Chapter>();
        List<Chapter> chilChapters = new ArrayList<Chapter>();
        Chapter testchil = new Chapter();
        String previous_id = "0";

        for (Chapter ChapterNode : chapters)
        {
            if (ChapterNode.getParent_id().equals(pNode.getChapter_id()))
            {
                chaptermap.put(ChapterNode.getPrevious_id(), ChapterNode);
            }
        }
        for (int i = 1; i < chaptermap.size(); i++)
        {
            testchil = buildChilTree(chaptermap.get(previous_id));
            if (testchil == null)
            {
                continue;
            }
            chilChapters.add(testchil);
//			chilChapters.add(buildChilTree(chaptermap.get(previous_id)));
            previous_id = chaptermap.get(previous_id).getChapter_id();
        }
        pNode.setChild_chapter(chilChapters);
        return pNode;
    }

    // 获取根节点
    private List<Chapter> getRootNode()
    {
        List<Chapter> rootChapterLists = new ArrayList<Chapter>();
        Map<String, Chapter> chaptermap = new HashMap<String, Chapter>();
        String previous_id = "0";
        // 获取第一级目录 即该章节的parent_id=0
        for (Chapter ChapterNode : chapters)
        {
            if (ChapterNode.getParent_id().equals("0"))
            {
                chaptermap.put(ChapterNode.getPrevious_id(), ChapterNode);
            }
        }
        // 将第一级目录排序
        for (int i = 0; i < chaptermap.size(); i++)
        {
            rootChapterLists.add(chaptermap.get(previous_id));
            previous_id = chaptermap.get(previous_id).getChapter_id();
        }
        return rootChapterLists;
    }
}